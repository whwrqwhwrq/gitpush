package wrq.mybatispage.manager.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import wrq.mybatispage.manager.IFirstManager;
import wrq.mybatispage.response.Response;
import wrq.mybatispage.utils.HttpClientUtil;

import java.util.HashMap;

/**
 * @Author:wrq
 * @Date:2021/1/8 15:40
 */
@Component
public class FirstManagerImpl implements IFirstManager {

    private static final String googleCollectUrl = "http://localhost:30002/jedar/wrqTest/testGoogleCollect";
    private static final String fillPlayerFieldsUrl = "http://localhost:30002/jedar/fillFields0/";

    @Override
    public Response getGoogleCollect() {
        String responseString = HttpClientUtil.get(googleCollectUrl);
        Response response = JSON.parseObject(responseString, new TypeReference<Response>(){});
        return response;
    }

    @Override
    public Response fillPlayFields() {
        HashMap<String, Object> params = Maps.newHashMapWithExpectedSize(2);
        params.put("name", "jedar0k");
        params.put("gender", "男");
        String responseString = HttpClientUtil.get(fillPlayerFieldsUrl,params,true);
        Response response = JSON.parseObject(responseString, new TypeReference<Response>(){});
        return response;
    }

    @Override
    public Response fillPlayFields0() {
        HashMap<String, Object> params = Maps.newHashMapWithExpectedSize(2);
        params.put("name", "jedar0k");
        params.put("gender", "男");
        String responseString = HttpClientUtil.get(fillPlayerFieldsUrl,params,false);
        Response response = JSON.parseObject(responseString, new TypeReference<Response>(){});
        return response;
    }

}
