package classExtends;

public class Father {
    public String c;
    protected String a = "父类的a";
    String b;
    private String d;

    public Father() {
    }

    public Father(String c, String a, String b, String d) {
        this.c = c;
        this.a = a;
        this.b = b;
        this.d = d;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

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

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
