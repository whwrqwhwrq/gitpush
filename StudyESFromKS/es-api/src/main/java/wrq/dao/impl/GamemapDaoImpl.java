package wrq.dao.impl;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import wrq.dao.GamemapDao;

import java.io.IOException;

/**
 * @Author:wrq
 * @Date:2020/11/11 17:38
 */
@Repository
public class GamemapDaoImpl implements GamemapDao {

    @Autowired
    private RestHighLevelClient client;
    @Override
    public String getGameMapByName(String name) throws IOException {
        SearchRequest searchRequest = new SearchRequest("gamemap");

        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", name);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(termQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        String sourceAsString = "";
        for (SearchHit hit : search.getHits()) {
            sourceAsString = hit.getSourceAsString();
        }
        return sourceAsString;
    }
}
