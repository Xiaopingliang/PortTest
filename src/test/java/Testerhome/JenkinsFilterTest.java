package Testerhome;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;

public class JenkinsFilterTest {


    public static String key;
    public static String value;
    //封装断言
    ResponseSpecification rs =new ResponseSpecBuilder().build();

    @BeforeClass
    public void setup(){

        RestAssured.baseURI="http://localhost:8080";

    }



    /**
     * Jenkins登录接口
     * 实现自动登录->自动打包
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
                .queryParams(map)
                .when()
                .post(portAddress)
                .then().spec(rs).extract().response();

        //读取响应结果里的Cookies
        Map<String,String> loginCookies=response.getCookies();
        filters(new Filter() {
            public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext filterContext) {
                requestSpec.cookies(loginCookies);
                Response response = filterContext.next(requestSpec, responseSpec);
                return response;
            }
        });

        Map<String,Object> paramMaps=new HashMap<String, Object>();
        paramMaps.put("delay","0sec");

        //接口地址
        String portAddress1="/job/PortTest/build";

        //封装cookie请求
        RequestSpecBuilder requestSpecBuilder =new RequestSpecBuilder();
        requestSpecBuilder.addCookie("Idea-a60d147b","5f2a8b50-3e9a-40c8-9453-184d4896692c");
        requestSpecBuilder.addCookie("ACEGI_SECURITY_HASHED_REMEMBER_ME_COOKIE","eGlhb3BpbmdsaWFuZzoxNTM4NDQzNTM3NjM1Ojg5NmU3OWVhNDY3Y2IyMGIwZjc3MGQ5OTJlZThkZmVhZWQ5YjI1MzBjM2U2ZTNhMzM3YjQ4NmMyYzcwMTViODE=");
        RequestSpecification requestSpecification=requestSpecBuilder.build();


        given()
                .spec(requestSpecification)
                .queryParams(paramMaps)
                .when()
                .post(portAddress1)
                .then()
                .statusCode(201);

    }
    */
}
