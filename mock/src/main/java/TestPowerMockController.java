import java.util.HashMap;
import java.util.Map;

/**
 * @Author:wrq
 * @Date:2021/1/28 14:08
 */
public class TestPowerMockController {

    public String build(String string) {
        String a = "a";
        String b = "b";

        Map<String, String> param = new HashMap<>();
        param.put("asdfasdf", "dafsdfs");

        TestUtil.sout();
        build(param);
        return a + b + string;
    }

    private String build(Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> ss : param.entrySet()) {
            sb.append(ss.getValue());
        }

        return sb.toString();
    }
}
