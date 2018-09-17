package Json;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;


import java.util.List;



public class JsonPathTest {

    String jsonstr = "{\"topics\":[{\"id\":10254,\"title\":\"优质招聘汇总\",\"created_at\":" +
            "\"2017-09-25T16:58:15.568+08:00\",\"updated_at\":\"2018-08-30T00:07:27.752+08:00\"," +
            "\"replied_at\":\"2018-08-30T00:07:27.717+08:00\",\"replies_count\":61,\"node_name\":" +
            "\"招聘\",\"node_id\":19,\"last_reply_user_id\":14521,\"last_reply_user_login\":\"sunny-ohh\"," +
            "\"excellent\":1,\"likes_count\":22,\"suggested_at\":\"2018-08-24T09:04:27.707+08:00\"," +
            "\"closed_at\":null,\"deleted\":false,\"user\":{\"id\":10433,\"login\":\"maine\",\"name\":\"" +
            "\",\"avatar_url\":\"/uploads/user/avatar/10433/b2db36.jpg!large\",\"abilities\":" +
            "{\"update\":false,\"destroy\":false}},\"hits\":22478,\"abilities\":{\"update\":false,\"destroy\":false,\"ban\":false,\"excellent\":false,\"unexcellent\":false,\"close\":false,\"open\":false}},{\"id\":15796,\"title\":\"[书香活动第一期] 予人玫瑰，手有余香\",\"created_at\":\"2018-08-23T20:21:17.259+08:00\",\"updated_at\":\"2018-09-01T10:19:46.262+08:00\",\"replied_at\":\"2018-08-31T10:07:16.582+08:00\",\"replies_count\":14,\"node_name\":\"书籍点评\",\"node_id\":22,\"last_reply_user_id\":28640,\"last_reply_user_login\":\"goodliving\",\"excellent\":0,\"likes_count\":14,\"suggested_at\":\"2018-08-24T09:01:27.787+08:00\",\"closed_at\":null,\"deleted\":false,\"user\":{\"id\":50,\"login\":\"simple\",\"name\":\"\",\"avatar_url\":\"/uploads/user/avatar/50.jpg!large\",\"abilities\":{\"update\":false,\"destroy\":false}},\"hits\":1498,\"abilities\":{\"update\":false,\"destroy\":false,\"ban\":false,\"excellent\":false,\"unexcellent\":false,\"close\":false,\"open\":false}},{\"id\":15741,\"title\":\"今日开放注册\",\"created_at\":\"2018-08-21T23:46:46.803+08:00\",\"updated_at\":\"2018-09-01T14:37:07.097+08:00\",\"replied_at\":\"2018-08-29T00:27:02.476+08:00\",\"replies_count\":38,\"node_name\":\"公告\",\"node_id\":130,\"last_reply_user_id\":25202,\"last_reply_user_login\":\"iqianxing\",\"excellent\":0,\"likes_count\":0,\"suggested_at\":\"2018-08-22T01:04:05.767+08:00\",\"closed_at\":null,\"deleted\":false,\"user\":{\"id\":110,\"login\":\"Lihuazhang\",\"name\":\"恒温\",\"avatar_url\":\"/uploads/user/avatar/110.jpg!large\",\"abilities\":{\"update\":false,\"destroy\":false}},\"hits\":2567,\"abilities\":{\"update\":false,\"destroy\":false,\"ban\":false,\"excellent\":false,\"unexcellent\":false,\"close\":false,\"open\":false}},{\"id\":15958,\"title\":\"今天终于收了一家创业公司的 OFFER，有希望不会饿死了，记录一下转行的艰辛吧。以后是再也不敢这么干了。。。\",\"created_at\":\"2018-08-31T21:25:59.975+08:00\",\"updated_at\":\"2018-09-01T19:20:33.886+08:00\",\"replied_at\":\"2018-09-01T19:20:33.864+08:00\",\"replies_count\":4,\"node_name\":\"AI测试\",\"node_id\":134,\"last_reply_user_id\":25202,\"last_reply_user_login\":\"iqianxing\",\"excellent\":0,\"likes_count\":5,\"suggested_at\":null,\"closed_at\":null,\"deleted\":false,\"user\":{\"id\":1706,\"login\":\"yangchengtest\",\"name\":\"magicyang\",\"avatar_url\":\"/uploads/user/avatar/1706.jpg!large\",\"abilities\":{\"update\":false,\"destroy\":false}},\"hits\":443,\"abilities\":{\"update\":false,\"destroy\":false,\"ban\":false,\"excellent\":false,\"unexcellent\":false,\"close\":false,\"open\":false}},{\"id\":15946,\"title\":\"吐槽一种面试官\",\"created_at\":\"2018-08-31T10:47:33.818+08:00\",\"updated_at\":\"2018-09-01T18:57:04.444+08:00\",\"replied_at\":\"2018-09-01T18:57:04.427+08:00\",\"replies_count\":10,\"node_name\":\"匿名吐槽\",\"node_id\":37,\"last_reply_user_id\":12,\"last_reply_user_login\":\"anonymous\",\"excellent\":0,\"likes_count\":0,\"suggested_at\":null,\"closed_at\":null,\"deleted\":false,\"user\":{\"id\":12,\"login\":\"anonymous\",\"name\":\"匿名\",\"avatar_url\":\"/uploads/user/avatar/12.jpg!large\",\"abilities\":{\"update\":false,\"destroy\":false}},\"hits\":636,\"abilities\":{\"update\":false,\"destroy\":false,\"ban\":false,\"excellent\":false,\"unexcellent\":false,\"close\":false,\"open\":false}}]}";



    @Test
    public void testconmtent(){

        JSONObject jsonObject=JSONObject.fromObject(jsonstr);
        System.out.println(jsonstr);
    }

    @Test
    public void test(){

//      获取topics中的第一个对象

        //Object object = JsonPath.read(jsonstr, "$.topics[0]");
        Object object = JsonPath.read(jsonstr,"topics[0]");

        System.out.println(object);

    }

    @Test
    public void test1(){

//      获取topics中的所有对象
        List<String> newslist = JsonPath.read(jsonstr, "$.topics[*]");
        System.out.println(newslist.size());

    }

    @Test
    public void test2(){

//      获取topics中的所有id
        List<String> ids = JsonPath.read(jsonstr, "$.topics[*].id");
        System.out.println(ids);

    }


    @Test
    public void test3(){

        //找到topics中node_id=130的所有的对象
        List<Object> lists = JsonPath.read(jsonstr, "$.topics[*][?(@.node_id == 130)]");
        for(int i =0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }

    }

    @Test
    public void test4(){

        //找到topics中node_id<100的所有的对象
        List<Object> lists = JsonPath.read(jsonstr, "$.topics[*][?(@.node_id < 100)]");
        for(int i =0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }

    }


    @Test
    public void test5(){

        //返回topics前二个对象
        List<Object> lists = JsonPath.read(jsonstr, "$.topics[0:2]");
        for(int i =0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }

    }


    @Test
    public void test6(){

        //返回topics前二个对象
        List<Object> lists = JsonPath.read(jsonstr, "$.topics[0:2].title");
        for(int i =0;i<lists.size();i++){
            System.out.println(lists.get(i));
        }

    }


    @Test
    public void test7(){

        //也可以这样定义路径
        JsonPath path = JsonPath.compile("$.topics[0:2].title");
        List<Object> userlist = path.read(jsonstr);
        for(int i =0;i<userlist.size();i++){
            System.out.println(userlist.get(i));
        }

    }

    @Test
    public void test8(){

        //我们还可以自定义过滤器来获取想要的任何元素，可以多条件查询；
        Filter filter = Filter.filter(Criteria.where("title").exists(true).and("title").in("优质招聘汇总", "车比得"));
        List<Object> finallist5 = JsonPath.read(jsonstr, "$.topics[?]", filter);
        for(int i =0;i<finallist5.size();i++){
            System.out.println(finallist5.get(i));
        }
    }




}
