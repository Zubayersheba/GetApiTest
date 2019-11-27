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
    @Test
    public void getApiTest() throws ClientProtocolException,IOException {
         restclient=new Restclient();
         restclient.get(url1);
       // System.out.println(url1);

    }
    @Test
    public void getApiTestSheba() throws ClientProtocolException,IOException {
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




    }
}
