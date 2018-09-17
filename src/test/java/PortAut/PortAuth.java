package PortAut;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class PortAuth {

    /*
    //配置RestAssured代理
    @BeforeClass
    public void setup(){

        RestAssured.proxy("127.0.0.1",8080);

    }


    //验证登录信息
    @Test
    public void auth(){

        given()
                .auth().basic("username","password")
        .when()
                .get("url")
        .then()
                .statusCode(200);
    }
    */
}
