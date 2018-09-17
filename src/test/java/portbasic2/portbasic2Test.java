package portbasic2;

import io.restassured.response.Response;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class portbasic2Test {

    @Test
    public void test1() {

        get("https://www.baidu.com").prettyPeek();
    }


    @Test
    public void testJsonObject() {

        String jsonstr= get("https://testerhome.com/api/v3/topics.json?limit=3&offset=0&type=last_actived").asString();


        //把字符串转换成json格式

        JSONObject jsonObject = JSONObject.fromObject(jsonstr);

        //获取topics下的值

        JSONArray jsonArray = jsonObject.getJSONArray("topics");

        // System.out.println(jsonArray);

        for (int i = 0; i < jsonArray.size(); i++) {

            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

            //打印topics下user的值
            //System.out.println(jsonObject1.getString("user"));

            if (jsonArray.get(i) instanceof JSONObject) {

                //获取topics下所有某个键的值
                JSONObject jsonObject2 = JSONObject.fromObject(jsonArray.get(i));
                //获取user下的值
                JSONObject jsonObject3 = (JSONObject) jsonObject2.get("user");

                if (jsonObject3 instanceof JSONObject) {

                    //打印user下login的值
                    System.out.println(jsonObject3.getString("login"));

                }
            }


        }

    }



    @Test
    public void test2(){


        get("https://testerhome.com/api/v3/topics.json?limit=3&offset=0&type=last_actived").prettyPrint();


    }


}