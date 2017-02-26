package ctone.rap.http;

import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyi on 2017/2/13.
 */
public class RapHttpClient {
    private CloseableHttpClient httpClient /*= HttpClients.createDefault()*/;
    private int soTimeout;
    private String charset;
    private int connectionRequestTimeout;
    private int connectTimeout;
    private int socketTimeout;
    private long connTimeToLive;
    private TimeUnit connTimeToLiveTimeUnit;
    private long maxIdleTime;
    private TimeUnit maxIdleTimeUnit;
    private int maxConnTotal;

    public void init(){
        SocketConfig socketConfig = SocketConfig.custom()
                .setSoTimeout(soTimeout)
                .build();
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setCharset(Charset.forName(charset))
                .build();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        httpClient = HttpClientBuilder.create()
                .setDefaultSocketConfig(socketConfig)
                .setDefaultConnectionConfig(connectionConfig)
                .setDefaultRequestConfig(requestConfig)
                .setConnectionTimeToLive(connTimeToLive,connTimeToLiveTimeUnit)
                .evictIdleConnections(maxIdleTime,maxIdleTimeUnit)
                .setMaxConnTotal(maxConnTotal)
                .build();
    }

    //get
    public String get(String url, Charset charset){
        HttpGet httpGet = new HttpGet(url);
        return execute(httpGet,charset);
    }

    //post
    public String post(String url, Map<String,String> params, Charset charset){
        HttpPost httpPost = new HttpPost(url);
        HttpEntity postEntity = new UrlEncodedFormEntity(map2NameValuePair(params),charset);
        httpPost.setEntity(postEntity);
        return execute(httpPost,charset);
    }

    public static List<NameValuePair> map2NameValuePair(Map<String,String> params){
        if (MapUtils.isEmpty(params)){
            return Collections.emptyList();
        }
        List<NameValuePair> list = new ArrayList<NameValuePair>(params.size());
        for (Map.Entry<String,String> entry:params.entrySet()){
            BasicNameValuePair basicNameValuePair = new BasicNameValuePair(entry.getKey(),entry.getValue());
            list.add(basicNameValuePair);
        }
        return list;
    }

    private final String execute(HttpRequestBase httpRequestBase, Charset charset){
        String text = null;
        CloseableHttpResponse response = null;
        try {
            httpClient.execute(httpRequestBase);
            if (response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                entity.getContent();
                text = EntityUtils.toString(entity,charset);
                EntityUtils.consume(entity);
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response!=null){
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return text;
    }

}
