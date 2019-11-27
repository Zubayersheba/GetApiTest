package restapi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {

    public int Response_code_200=200;
    public int Response_code_500=500;
    public int Response_code_400=400;
    public int Response_code_401=401;
    public int Response_code_201=201;

    public Properties prop;
    public TestBase(){


        try{

            prop=new Properties();
            FileInputStream ip;
            ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/restapi/config/config.properties");
            prop.load(ip);
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
