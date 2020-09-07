package wrq;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import wrq.pojo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class EsApiApplicationTests {
    @Autowired
    private RestHighLevelClient client;
    @Test
    //创建索引
    void createIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest indexRequest = new CreateIndexRequest("jedar0k");
        //执行 创建的请求,获得响应
        CreateIndexResponse indexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse);
    }

    //获取索引
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("jedar");
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //删除索引
    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("jedar0k");
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = delete.isAcknowledged();
        System.out.println(acknowledged);
    }
    //创建文档
    @Test
    void createDoc() throws IOException {
        User user = new User();
        user.setAge(3);
        user.setName("生番");
        //创建请求
        IndexRequest indexRequest = new IndexRequest("jedar0k");
        //规则
        indexRequest.id("1");
        indexRequest.timeout("1s");
        //数据放入请求
        IndexRequest source = indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        //客户端发送请求
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        RestStatus status = index.status();
        String s = index.toString();
        System.out.println(s);
        System.out.println(status);
    }

    //获取文档，判断是否存在
    @Test
    void existDoc() throws IOException {
        GetRequest getRequest = new GetRequest("jedar0k","1");
        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //获取文档的信息
    @Test
    void getDocMessage() throws IOException {
        GetRequest getRequest = new GetRequest("jedar0k","1");
        GetResponse documentFields = client.get(getRequest, RequestOptions.DEFAULT);
        Map<String, Object> source = documentFields.getSource();
        String s = JSON.toJSONString(source);
        System.out.println(s);
        System.out.println(source);
        String sourceAsString = documentFields.getSourceAsString();
        System.out.println(sourceAsString);
    }

    //更新文档 用mapper
    @Test
    void updateDoc() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("jedar0k","1");
        updateRequest.timeout("1s");
        HashMap<String, Object> userMap = new HashMap<>();
        userMap.put("name", "Rich Brian");
        userMap.put("age", 16);
        updateRequest.doc(userMap);
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse);
    }
    //更新文档  用json字符串
    @Test
    void updateDoc1() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("jedar0k","1");
        updateRequest.timeout("1s");
        User user = new User("王瑞麒",3);
        updateRequest.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(updateResponse);
    }
    //删除文档
    @Test
    void deleteDoc() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("jedar0k", "3");
        DeleteResponse delete = client.delete(deleteRequest, RequestOptions.DEFAULT);
        RestStatus status = delete.status();
        System.out.println(status);
    }

    @Test
    void add() throws IOException {
        IndexRequest indexRequest = new IndexRequest("jedar");
        indexRequest.id("3");
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","埃米纳姆");
        map.put("age",23);
        map.put("gender","男");
        indexRequest.source(map);
        IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index.toString());
    }

    //批量插入数据
    @Test
    void bulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("aaa", 3));
        users.add(new User("aaaa", 3));
        users.add(new User("aaaaa", 3));
        users.add(new User("aaaaaa", 3));
        users.add(new User("aaaaaaa", 3));
        users.add(new User("aaaaaaaa", 3));
        users.add(new User("aaaaaaaaa", 3));

        for (int i = 0; i < users.size(); i++) {
            bulkRequest.add(new IndexRequest("jedar0k")
                    .id("" + (i + 6))
                    .source(JSON.toJSONString(users.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());
        System.out.println(bulk);
    }

    //查询
    @Test
    void search() throws IOException {
        SearchRequest searchRequest = new SearchRequest("jedar0k");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //TermQueryBuilder termQueryBuilder = new TermQueryBuilder("name", "aaa");
        MatchAllQueryBuilder matchAllQueryBuilder = new MatchAllQueryBuilder();
        //MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name","aaa");
        searchSourceBuilder.query(matchAllQueryBuilder);
        searchSourceBuilder.from();
        searchSourceBuilder.size(5);
        searchRequest.source(searchSourceBuilder);

        SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(search.getHits().getTotalHits());
        for (SearchHit hit : search.getHits()) {
            System.out.println(hit);
        }
    }
}
