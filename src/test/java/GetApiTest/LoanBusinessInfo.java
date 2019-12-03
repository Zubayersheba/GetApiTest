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

public class LoanBusinessInfo extends TestBase{

    TestBase testbase;
    String serviceUrl;
    String apiurl;
    String url1;
    String urlbusinessinfoapi;
    Restclient restclient2;
    CloseableHttpResponse closeableHttpResponse;
    public int partner_id=3258;

    @BeforeMethod
    public void setUpnew() throws IOException {
       // serviceUrl=prop.getProperty("url");
      //  apiurl=prop.getProperty("serviceURL");
        String serviceUrlsheba = prop.getProperty("urlsheba");
        String apiurlsheba = prop.getProperty("businessinfoapi");
        //url1=serviceUrl+apiurl;
        urlbusinessinfoapi = serviceUrlsheba + apiurlsheba;


    }

    @Test
    public void getBusinessApiTestSheba() throws ClientProtocolException,IOException{
        restclient2=new Restclient();
        closeableHttpResponse = restclient2.get(urlbusinessinfoapi);
        System.out.println("---Status code----->" + urlbusinessinfoapi);
        int statuscode2= closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("---Status code----->" + statuscode2);
        Assert.assertEquals("Status code is not 200",statuscode2,Response_code_200);

        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responseJson=new JSONObject(responseString);
        System.out.println("--Json objects---->" + responseJson);

        String perpagevalue= TestUtil.getValueByJPath(responseJson, "/code");
        int code=  Integer.parseInt(perpagevalue);
        System.out.println("--code---->" + code);
        Assert.assertEquals(200,code);

    }
}

