package Testerhome;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.ResponseLogSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import static io.restassured.RestAssured.*;
public class JenkinsTest {


    ResponseSpecification rs =new ResponseSpecBuilder().build();
    public static String key;
    public static String value;

    @BeforeClass
    public void setup(){

        RestAssured.baseURI="http://localhost:8080";

    }

    /**
     * Jenkins登录接口
     * 实现自动登录
     */
    /*
    @Test
    public void loginJenkins(){
        //请求参数
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("j_password","Lxp354985654");
        map.put("from","%2F");
        map.put("j_username","Xiaopingliang");
        map.put("Submit","%E7%99%BB%E5%BD%95");

        //接口地址
        String portAddress="/j_acegi_security_check";

        //断言
        rs.statusCode(302);

        Response response= given()
                .log().all()
                                 .queryParams(map)
                          .when()
                .log().all()
                                 .post(portAddress)
                          .then()
                .log().all()
                .spec(rs).extract().response();

        //读取响应结果里的Cookie
        Map<String,String> loginCookies=response.getCookies();
        //将loginCookies里的键值对分开取出来
        Iterator<Map.Entry<String, String>> iterator = loginCookies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
             key = entry.getKey();
             value = entry.getValue();
            System.out.printf("key= "+key+"  "+"value= "+value);
        }

    }


    /**
     * 实现PortTest项目自动打包
     */
    /*
    @Test(dependsOnMethods = "loginJenkins")
    public void autoBuild(){

        Map<String,Object> paramMaps=new HashMap<String, Object>();
        paramMaps.put("delay","0sec");

        //接口地址
        String portAddress="/job/PortTest/build";
        //断言
        rs.statusCode(200);


                given()
                        .cookie(key,value)
                        .cookies("Idea-a60d147b","5f2a8b50-3e9a-40c8-9453-184d4896692c")
                        .cookies("ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE","eGlhb3BpbmdsaWFuZzoxNTM4NDQzNTM3NjM1Ojg5NmU3OWVhNDY3Y2IyMGIwZjc3MGQ5OTJlZThkZmVhZWQ5YjI1MzBjM2U2ZTNhMzM3YjQ4NmMyYzcwMTViODE=")
                        .queryParams(paramMaps)
                .when()
                        .post(portAddress)
                .then()
                        .spec(rs)
                ;

    }
    */
}

