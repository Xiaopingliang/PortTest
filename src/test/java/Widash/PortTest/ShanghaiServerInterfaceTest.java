package Widash.PortTest;

import Widash.Utils.PublicParameter;
import Widash.Utils.Random;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import net.sf.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.containsString;

import java.util.HashMap;



public class ShanghaiServerInterfaceTest {

    ResponseSpecification rs =  new ResponseSpecBuilder().build();


    @BeforeClass
    public void setup(){

        RestAssured.baseURI="https://app.tccpay.com";

        rs.statusCode(200);


    }

    /**
     * 上海网络响应时间监控接口
     */
    @Test
    public void networkResponseTime(){


        //rs.body(containsString("一二三四五六七八九十一二三四五六七八九十"));
        given()
                .when().get("/test/te").prettyPeek();
                //.then().spec(rs);

    }

    /**
     * 下单接口
     */
    @Test
    public void createOrder() {


        com.wiwide.encryptsdk.Test test = new com.wiwide.encryptsdk.Test();

        test.clearParams();
        test.addParam("rand",Random.RandomString());
        test.addParam("return_url","http://baidu.com");
        test.addParam("out_trade_no",Random.RandomInt());
        test.addParam("coin_type","TCC");
        test.addParam("coin_total","0.01");
        test.addParam("coin_address","0x25f714674f64bb0ee09d96e6694aad7e8c9bf2a9");
        test.addParam("time_start","201807190524");
        test.addParam("time_end","201807202355");
        test.addParam("goods_desc","一卡通充值");
        test.addParam("goods_detail","高飞");

        String data = test.getData(PublicParameter.mch_secret,PublicParameter.secret,PublicParameter.iv);
        String sc = test.getSc(PublicParameter.secret,PublicParameter.publicKey);
        HashMap<String,Object> maps = new HashMap<String, Object>();
        maps.put("data",data);
        maps.put("sc",sc);
        maps.put("iv",PublicParameter.iv);
        maps.put("mch_secret",PublicParameter.mch_secret);

        rs.body(containsString("return_code\":\"success"));
        given().params(maps).when().get("/cashier/payment").prettyPeek().then().spec(rs);

       Response response =  given().params(maps)
                                    .when().get("/cashier/payment").prettyPeek()
                                    .then().spec(rs).extract().response();


       //将接口返回值转换成字符串类型
       String abs= given().params(maps).when().get("/cashier/payment").asString();

       //将字符串转换成json格式
        JSONObject jsonObject = JSONObject.fromObject(abs);
        //获取"return_data"的值
        JSONObject jsonObject1= (JSONObject) jsonObject.get("return_data");
        //获取"out_trade_no"和"trade_no"的值
        jsonObject1.get("out_trade_no");
        jsonObject1.get("trade_no");

        System.out.println(jsonObject1.get("out_trade_no"));

    }


    @Test
    public void payorder(){




    }


    }
