package GetApiTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.classData.Users;
import com.restapi.client.Restclient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restapi.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class PostApiTest extends TestBase {

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
        url1=serviceUrl+apiurl;
        //Shebaurl
        /*String serviceUrlsheba = prop.getProperty("urlsheba");
         String apiurlsheba = prop.getProperty("serviceURLsheba");
        url1sheba = serviceUrlsheba + apiurlsheba; */


    }
    @Test
    public void postApiTest() throws IOException {

        restclient= new Restclient();
        HashMap<String,String> headerMap= new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
       // headerMap.put("remember-token","xyz");

        //jackson api
        ObjectMapper mapper=new ObjectMapper();
        Users users=new Users("kabir","TL"); //expected user object , declare object and pass data in constructor

        //object to json
        mapper.writeValue(new File("F:\\ApiTest\\src\\main\\java\\com\\qa\\classData\\users.json"), users);

        //object to json in string
        String  userjsonstring=mapper.writeValueAsString(users);
        System.out.println(userjsonstring);

        closeableHttpResponse= restclient.post(url1,userjsonstring,headerMap);
        //server response statuscode
        int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(statuscode,Response_code_201);//server hit response

        //jsonstring
       String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        JSONObject responsejson=new JSONObject(responseString);
        System.out.println("Response from Api is--->"+ responseString);

        Users userResponseobj=mapper.readValue(responseString,Users.class);//actual response from api
        //System.out.println(userResponseobj);

       //Check post data with expected result
       // System.out.println(users.getName().equals(userResponseobj.getName()));
       // System.out.println(users.getJob().equals(userResponseobj.getName()));
        Assert.assertEquals("zubayer",users.getName());
       // System.out.println(users.getJob());






    }

}
