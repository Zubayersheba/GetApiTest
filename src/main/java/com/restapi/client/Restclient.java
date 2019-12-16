package com.restapi.client;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Restclient {

    public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the get url
        //json string
       /* String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println("--Json objects---->" + responseJson);*/
        return closeableHttpResponse;

    }

    //post method
    public CloseableHttpResponse post(String url,String entityString, HashMap<String,String> headermap) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(entityString)); //for payload


        //for headers
        for (Map.Entry<String,String> entry: headermap.entrySet()){

            httpPost.addHeader(entry.getKey(),entry.getValue());
        }

        CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpPost);
        return closeableHttpResponse;


    }

}
