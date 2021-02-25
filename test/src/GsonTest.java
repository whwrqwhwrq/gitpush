import com.google.gson.Gson;

/**
 * @Author:wrq
 * @Date:2021/2/24 11:34
 */
public class GsonTest {
    private static final Gson gson = new Gson();
    public static void main(String[] args) {
        A a = new A();
        a.setA("adsfasdf");
        a.setB("adsfasdffasdf");

        String s = gson.toJson(a);
        System.out.println(s);
    }

    static class A {
        private String a;
        private String b;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
