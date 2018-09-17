package FilterAssert;
import io.restassured.builder.ResponseBuilder;
import io.restassured.config.JsonConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.ContentType;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.commons.net.util.Base64;
import org.junit.Test;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class FilterTest {


    /**
     *filter机制，增加参数
     */
    @Test
    public void reponseFilter() {


        filters((new Filter() {
                    @Override
                    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
                        System.out.println("request filter");
                        System.out.println(requestSpec.getQueryParams());
                        requestSpec.queryParam("symbol", "SH000002");
                        //requestSpec.removeQueryParam("symbol");
                        Response response = ctx.next(requestSpec, responseSpec);
                        System.out.println("response filter");
                        return response;

                    }
                })
        );

        given()
                .log().all()
                //返回值类型设置为浮点数
                .config(RestAssuredConfig.config().jsonConfig(JsonConfig.jsonConfig().numberReturnType(JsonPathConfig.NumberReturnType.DOUBLE)))
                .queryParam("symbol", "SH000001")
                .cookie("xq_a_token", "9c75d6bfbd0112c72b385fd95305e36563da53fb")
                .when()
                .get("https://stock.xueqiu.com/v5/stock/batch/quote.json")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.items.quote.find { it.symbol == 'SH000001'}.name", equalTo("上证指数"))
                //.body("data.items.quote.find { it.symbol == 'SH000001'}.current", equalTo(2653f))
               // .body("data.items.quote.find { it.symbol == 'SH000001'}.current.toDouble()", closeTo(2653.64, 100))
        ;

    }

    /**
     * filter机制，解密响应
     */

    /*
    @Test
    public void reponseFilter2(){

        filters((new Filter() {
                    @Override
                    public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
                        Response response = ctx.next(requestSpec, responseSpec);

                        String content=new String(response.getBody().asString());
                        Response Response2 = new ResponseBuilder().clone(response).setContentType(ContentType.JSON).setBody(content).build();
                        return Response2;
                    }
                })
        );
        given()
                .proxy("127.0.0.1", 8080)
                .auth().basic("hogwarts", "123456")
                .when()
                .get("http://jenkins.testing-studio.com:9001/base64.json")
                .then()
                .log().all()
                .statusCode(200)
                .body("data.items.quote.find { it.symbol == 'SH000001'}.name", equalTo("上证指数"))
                .body("data.items.quote.find { it.symbol == 'SH000001'}.current", equalTo(2681.64f))
                .body("data.items.quote.find { it.symbol == 'SH000001'}.current.toDouble()", closeTo(2681.64, 100))
        ;
    }


*/

}
