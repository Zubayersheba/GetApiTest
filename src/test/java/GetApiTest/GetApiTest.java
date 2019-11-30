package GetApiTest;

import com.restapi.client.Restclient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restapi.TestBase;
import util.com.testapi.TestUtil;


import java.io.IOException;
import java.util.HashMap;

public class GetApiTest extends TestBase {
    TestBase testbase;
    String serviceUrl;
    String apiurl;
    String url1;
    String url1sheba;
    Restclient restclient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod
    public void setUp() throws IOException {
       // testbase=new TestBase();
        serviceUrl=prop.getProperty("url");
        apiurl=prop.getProperty("serviceURL");
        String serviceUrlsheba = prop.getProperty("urlsheba");
        String apiurlsheba = prop.getProperty("serviceURLsheba");
         url1=serviceUrl+apiurl;
        url1sheba = serviceUrlsheba + apiurlsheba;
       /* Restclient restclient=new Restclient();
        CloseableHttpResponse closeableHttpResponse = restclient.get(url1);
        Restclient restclientsheba=new Restclient();
        restclient.get(url1);*/

    }
  /*  @Test
    public void getApiTest() throws ClientProtocolException,IOException {
         restclient=new Restclient();
         restclient.get(url1);
       // System.out.println(url1);

    }*/
  /*public void addresses() throws IOException {
      String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
      JSONObject responseJson=new JSONObject(responseString);

      String address= TestUtil.getValueByJPath(responseJson, "/addresses[0]/address");
      String id= TestUtil.getValueByJPath(responseJson, "/addresses[0]/id");
      String location_id= TestUtil.getValueByJPath(responseJson, "/addresses[0]/location_id");
      String name= TestUtil.getValueByJPath(responseJson, "/addresses[0]/name");
      String flat_no= TestUtil.getValueByJPath(responseJson, "/addresses[0]/flat_no");
      String geo_lng= TestUtil.getValueByJPath(responseJson, "/addresses[0]/geo_informations/lng");
      String geo_lat= TestUtil.getValueByJPath(responseJson, "/addresses[0]/geo_informations/lat");

      System.out.println("--ID---->" + id);
      System.out.println("--Location ID---->" + location_id);
      System.out.println("--Address---->" + address);
      System.out.println("--Address Name---->" + name);
      System.out.println("--Flat No---->" + flat_no);
      System.out.println("--Geo_informations lng---->" + geo_lng);
      System.out.println("--Geo_informations lat---->" + geo_lat);

  }*/
    @Test
    public void getApiTestSheba() throws ClientProtocolException,IOException {
        restclient=new Restclient();
        closeableHttpResponse = restclient.get(url1sheba);
        //Status code
        int statuscode= closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("---Status code----->" + statuscode);
        //Assert.assertEquals(statuscode, Response_code_201, "Status code is not 200");
        Assert.assertEquals("Status code is not 200",Response_code_200,statuscode);

       //json string
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println("--Json objects---->" + responseJson);



        // get value from address json array
        System.out.println("\n---------------------- \n" );

        String address= TestUtil.getValueByJPath(responseJson, "/addresses[0]/address");
        String id= TestUtil.getValueByJPath(responseJson, "/addresses[0]/id");
        String location_id= TestUtil.getValueByJPath(responseJson, "/addresses[0]/location_id");
        String name= TestUtil.getValueByJPath(responseJson, "/addresses[0]/name");
        String flat_no= TestUtil.getValueByJPath(responseJson, "/addresses[0]/flat_no");
        String geo_lng= TestUtil.getValueByJPath(responseJson, "/addresses[0]/geo_informations/lng");
        String geo_lat= TestUtil.getValueByJPath(responseJson, "/addresses[0]/geo_informations/lat");

        System.out.println("--ID---->" + id);
        System.out.println("--Location ID---->" + location_id);
        System.out.println("--Address---->" + address);
        System.out.println("--Address Name---->" + name);
        System.out.println("--Flat No---->" + flat_no);
        System.out.println("--Geo_informations lng---->" + geo_lng);
        System.out.println("--Geo_informations lat---->" + geo_lat);

    }
    /*public void getApiTestSheba() throws ClientProtocolException,IOException {
        restclient=new Restclient();
         closeableHttpResponse = restclient.get(url1);
         //Status code
        int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("---Status code----->" + statuscode);
        //Assert.assertEquals(statuscode, Response_code_201, "Status code is not 200");
        Assert.assertEquals("Status code is not 200",Response_code_200,statuscode);

        //json string
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println("--Json objects---->" + responseJson);

        //per_page value
        String perpagevalue= TestUtil.getValueByJPath(responseJson, "/per_page");
        int per_page_value=  Integer.parseInt(perpagevalue);
        System.out.println("--Per Page value---->" + perpagevalue);
        Assert.assertEquals(6,per_page_value);

        //total value
        String totalvalue= TestUtil.getValueByJPath(responseJson, "/total");
        int total_value=  Integer.parseInt(totalvalue);
        System.out.println("--Total value---->" + total_value);
        Assert.assertEquals(12,total_value);

        // get value from json array

       String last_name= TestUtil.getValueByJPath(responseJson, "/data[0]/last_name");
       String id= TestUtil.getValueByJPath(responseJson, "/data[0]/id");
       String first_name= TestUtil.getValueByJPath(responseJson, "/data[0]/first_name");
       String avatar= TestUtil.getValueByJPath(responseJson, "/data[0]/avatar");
       String email= TestUtil.getValueByJPath(responseJson, "/data[0]/email");

        System.out.println("--ID---->" + id);
        System.out.println("--Email---->" + email);
        System.out.println("--First Name---->" + first_name);
        System.out.println("--Last Name---->" + last_name);
        System.out.println("--Avatar---->" + avatar);

    }*/


}
