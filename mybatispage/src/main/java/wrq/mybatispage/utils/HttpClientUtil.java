package wrq.mybatispage.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2021/1/8 15:19
 */
@Component
public class HttpClientUtil {
    private static CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    public static String get(String url) {
        String resStr = "";
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);// 响应模型
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("响应状态为"+response.getStatusLine());
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                resStr = EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resStr;
    }

    public static String get(String url, Map<String,Object> params,boolean restful) {
        String resStr = "";
        String finalUrl;
        HttpGet httpGet = null;

        if (url.endsWith("/")) {
            finalUrl = url.substring(0, url.length() - 1);
        } else {
            finalUrl = url;
        }

        if (restful) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                stringBuffer.append("/").append(param.getValue());
            }
            finalUrl += stringBuffer.toString();
            httpGet = new HttpGet(finalUrl);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("?");
            for (Map.Entry<String, Object> param : params.entrySet()) {
                stringBuffer.append(param.getKey()).append("=").append(param.getValue()).append("&");
            }
            String temp = stringBuffer.toString();
            String temp2 = temp.substring(0, temp.length() - 1);
            finalUrl += temp2;
            httpGet = new HttpGet(finalUrl);
        }
        // 创建Get请求
       // 响应模型
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
            System.out.println("响应状态为"+response.getStatusLine());
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                resStr = EntityUtils.toString(httpEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resStr;
    }

}
