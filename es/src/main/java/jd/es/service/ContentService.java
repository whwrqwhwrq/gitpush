package jd.es.service;

import com.alibaba.fastjson.JSON;
import jd.es.pojo.Content;
import jd.es.utils.JsoupUtil;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ContentService {
   @Autowired
    private RestHighLevelClient client;

    //解析数据，放入ES索引库中
    public Boolean parseContent(String keyword) throws IOException {
        BulkResponse bulk = null;
        List<Content> contents = JsoupUtil.parseJD(keyword);
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2m");

        for (Content content : contents) {
            IndexRequest indexRequest = new IndexRequest("jd");
           //不写 ID  ,随机id
            indexRequest.source(JSON.toJSONString(content), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        try {
            bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return bulk.hasFailures();
        }
        return !bulk.hasFailures();
    }

    //获取ES的数据，实现搜索功能
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo < 1) {
            pageNo = 1;
        }
        List<Map<String, Object>> searchPageList = new ArrayList<>();//用来存放和返回最后的数据

        SearchRequest searchRequest = new SearchRequest("jd");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("title", keyword));
        searchSourceBuilder.from((pageNo - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            searchPageList.add(sourceAsMap);
        }
        return searchPageList;
    }
    //高亮
    public List<Map<String, Object>> searchPageHighlight(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo < 1) {
            pageNo = 1;
        }
        List<Map<String, Object>> searchPageList = new ArrayList<>();//用来存放和返回最后的数据

        SearchRequest searchRequest = new SearchRequest("jd");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().query(new TermQueryBuilder("title", keyword));
        searchSourceBuilder.from((pageNo-1)*pageSize);
        searchSourceBuilder.size(pageSize);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("title");
        highlightBuilder.preTags("<span style='color:red;font-weight:bold'>");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        for (SearchHit hit : search.getHits()) {
            //解析高亮 的 字段
            //获取高亮字段
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField title = highlightFields.get("title");
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();//原先无高亮的结果
            if (title != null) {
                //用高亮字段  替换  无高亮 的字
                Text[] fragments = title.fragments();
                String titleHighlight = "";
                for (Text fragment : fragments) {
                    titleHighlight+=fragment;
                }
                sourceAsMap.put("title", titleHighlight);
            }
            searchPageList.add(sourceAsMap);
        }
        return searchPageList;
    }

}


