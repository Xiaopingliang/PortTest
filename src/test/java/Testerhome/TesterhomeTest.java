package Testerhome;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;


import static io.restassured.RestAssured.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.lessThan;


public class TesterhomeTest {

    //封装断言
    static ResponseSpecification rs = new ResponseSpecBuilder().build();

    @BeforeClass
    public static void setup(){

        useRelaxedHTTPSValidation();
        RestAssured.baseURI="https://testerhome.com";
        // RestAssured.proxy("127.0.0.1",8080);

        rs.statusCode(200);
        rs.body(not(containsString("error")));
        rs.time(lessThan(2000L));
    }

    @Test
    public void testHtml(){

        given().queryParam("q","appium")
                .when().get("/search").prettyPeek()
                .then()
                .spec(rs)
                .body("html.head.title",equalTo("appium · 搜索结果 · TesterHome"));



    }

    //topics.title, topics下所有title的值
    //topics.title[1]，topics下第二个title的值
    //topics.id[-1], 查询topics下最后一个id的值

    @Test
    public void testJson(){

        given().when().get("/api/v3/topics.json")
                .then().statusCode(200);
//                .body("topics.title",hasItem("优质招聘汇总"))
//                .body("topics.title[1]",equalTo("优质招聘汇总"))
//                .body("topics.id[-1]",equalTo(15329));
    }


    @Test
    public void testSearch(){

        given().queryParam("q","霍格沃兹测试学员")
                .when().get("/search")
                .prettyPeek().then()
                .statusCode(200);
                //.body("topics.find{ topic->topic.id == 10254}.title",equalTo("优质招聘汇总"));
    }


    /**
     * 讲请求转换为JSON格式
     */
    //将参数转化为json格式
    /*
    @Test
    public void HashMaptoJSON(){


        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("name","liangxiaoping");
        map.put("age",18);
        map.put("id",354985654);

        given()
                .contentType(ContentType.JSON)
                .body(map)
        .when()
                .post("http://www.baidu.com")
        .then()
                .statusCode(200);

    }
    @Test
    public  void getName(){
       Response response = given().get("/api/v3/topics/6040.json").prettyPeek()
               .then()
               .statusCode(200).extract().response();

         String name = response.path("topic.user.name");
         int id = response.path("topic.user.id");




    }

    */
    @Test( )
    public void search(){

        Response response = given().get("/api/v3/topics/6040.json").prettyPeek()
                .then()
                .statusCode(200).extract().response();

        String name = response.path("topic.user.name");
        int id = response.path("topic.user.id");



        given().queryParam("q",name)
        .when()
                .get("/search").prettyPeek()
         .then()
                .statusCode(200).body(containsString(name));

    }


    //封装断言
    @Test
    public void testSpec(){

        ResponseSpecification rs = new ResponseSpecBuilder().build();
        rs.statusCode(200);
        rs.body(not(containsString("error")));
        rs.time(lessThan(2000L));

        given().queryParam("q","思寒")
                .when()
                .get("/search").prettyPeek()
                .then().spec(rs);
    }

    /**
     *从接口中找出来title是“美团技术沙龙北京站：千万级日活 App 的质量保证”的作者
     */
    @Test
    public void testhome(){

        useRelaxedHTTPSValidation();
        given().queryParam("limit",20)
                .log().all()
                .when().get("/api/v3/topics.json")
                .then()
                .log().all()
                .body("topics.find{ it.title == '美团技术沙龙北京站：千万级日活 App 的质量保证'}.user.name",equalTo("美团点评"));

    }


    /**
     * HTTP认证->用户名密码
     *
     */
    /*
    @Test
    public void httpcertification(){

        given().auth().basic("hogwarts","123456")
                .when().get("http://jenkins.testing-studio.com:9001/")
                .then().statusCode(200);

    }

    /**
     * Http认证->auto
     */

    /*
    @Test
    public void httpToken(){

        given().auth().oauth2("token").get("url").then().statusCode(200);

    }

    /**
     * 用自己的浏览器访问雪球，找到quote.json接口，对它进行基础的一个查询测试，断言对应的股票的基础属性
     */



    @Test
    public void xueqiu(){


        //封装请求
        RequestSpecBuilder requestSpecBuilder=new RequestSpecBuilder();
        requestSpecBuilder.addCookie("xq_a_token","9c75d6bfbd0112c72b385fd95305e36563da53fb");

        RequestSpecification rs1 =requestSpecBuilder.build();



        given()
                .queryParam("symbol","SH000001")
                .spec(rs1)
                .log().all()
                .when()
                .log().all()
                .get("https://stock.xueqiu.com/v5/stock/batch/quote.json")
                .then()
                .body("data.items[0].size()",equalTo(3))
               // .body("data.items[0].market.status",equalTo("交易中"))
                .body("data.items[0].quote.exchange",equalTo("SH"))
                //find找到的size是data.items.quote的size,findAll找到的size是exchange的size
                .body("data.items.quote.findAll{it.exchange == 'SH'}.size()",equalTo(1));

    }

}
