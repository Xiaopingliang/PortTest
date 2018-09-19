package Testerhome;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.SessionConfig;
import io.restassured.filter.session.SessionFilter;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class JenkinsSessionfilterTest {


    ResponseSpecification rs =new ResponseSpecBuilder().build();
    public static SessionFilter sessionFilter;

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

        //修改sessionId
       RestAssured.config= RestAssured.config().sessionConfig(new SessionConfig().sessionIdName("JSESSIONID.ed8252ed"));

       //设置sessionFilter，自动通过sessionID查找对应的value
        sessionFilter=new SessionFilter();

        given()
                .filter(sessionFilter)
                .queryParams(map)
                .when()
                .post(portAddress)
                .then().spec(rs);



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
                .log().all()
                .filter(sessionFilter)
                .cookies("Idea-a60d147b","5f2a8b50-3e9a-40c8-9453-184d4896692c")
                .cookies("ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE","eGlhb3BpbmdsaWFuZzoxNTM4NDQzNTM3NjM1Ojg5NmU3OWVhNDY3Y2IyMGIwZjc3MGQ5OTJlZThkZmVhZWQ5YjI1MzBjM2U2ZTNhMzM3YjQ4NmMyYzcwMTViODE=")
                .queryParams(paramMaps)
                .when()
                .log().all()
                .post(portAddress)
                .then()
                .log().all()
                .spec(rs)
        ;

    }

    */
}
