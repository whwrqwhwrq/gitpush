import java.util.HashMap;

/**
 * @Author:wrq
 * @Date:2021/1/11 17:56
 */
public class StringTest {
    public static void main(String[] args) {
        String string = "man/mns/jukj/nsdl/jklj.dfdf.dasd";
        int index = string.lastIndexOf("/");
        String substring = string.substring(0, index+1);
        String substring1 = string.substring(0, index);

        System.out.println(substring);
        System.out.println(substring1);

        HashMap<String, String> map = new HashMap<>();
        map.put("test", "test");

        String test = "coupon_info#{map.get('test')}";
        System.out.println(test);
    }
}
