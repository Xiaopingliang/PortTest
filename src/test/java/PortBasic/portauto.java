package PortBasic;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class portauto {

    //配置RestAssured代理
    @BeforeClass
    public static void setup(){

       // RestAssured.proxy("127.0.0.1",8080);

    }


    //直接请求
    @Test
    public void gettest() {

        get("https://testerhome.com/api/v3/topics/json?limit=2&offset=0&type=last_actived").prettyPeek();

    }

    //将参数放入map中请求
    @Test
    public void gettest2(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("limit",2);
        map.put("offset",0);
        map.put("type","last_actived");
        given().params(map).get("https://testerhome.com/api/v3/topics/json").prettyPeek();
    }

    //用given.param入参
    @Test
    public void gettest3(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("limit",2);
        map.put("offset",0);
        map.put("type","last_actived");
        given().param("limit",2).param("offset",0).param("type","last_actived").get("https://testerhome.com/api/v3/topics/json").prettyPeek();
    }



    public void gettest4(){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("topicid",12192);
        map.put("topics","topics");
        get("https://testerhome.com/{topicid}/{topics}",map).prettyPeek();
    }

    public static void main(String[] args) {


    }

}

