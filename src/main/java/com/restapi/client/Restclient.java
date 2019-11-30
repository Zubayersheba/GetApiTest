package com.restapi.client;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Restclient {
    //Get method
   // int statuscode;
    // without header
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
    // with header
    /*public CloseableHttpResponse get(String url, HashMap<String, String> hashMap) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        for(Map.Entry<String, String> entry: headerMap.entrySet()){
            httpGet.addHeader(entry.getKey(), entry.getValue());
        }
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);//hit the get url
        //json string
       /* String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println("--Json objects---->" + responseJson);
        return closeableHttpResponse;

    }*/
}
