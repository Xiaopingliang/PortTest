package Widash.Utils;

public class Random {


    /**
     * 生成10位随机字符串
     */
    public static String RandomInt(){

        //定义一个字符串（A-Z，a-z，0-9，共62位
        String str="1234567890";

        //由Random生成随机数
        java.util.Random random=new java.util.Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<10; ++i){
            //产生0-61的数字
            int number=random.nextInt(10);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

    /**
     * 生成16位随机字符串
     */
    public static String RandomString(){

        //定义一个字符串（A-Z，a-z，0-9，共62位
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        //由Random生成随机数
        java.util.Random random=new java.util.Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<16; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }
}

