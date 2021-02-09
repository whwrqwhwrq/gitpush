public class TestOverload {
    private String name;
    private Integer age;

    private void getAll(String name,Integer age) {
        this.name = name;
        this.age = age;
        System.out.println(name + age);
    }

    private String getAll(String name,Integer age,String s) {
        this.name = name;
        this.age = age;
        return this.name+this.age+s;
    }

    public static void main(String[] args) {
        TestOverload testOverload = new TestOverload();
        testOverload.getAll("wrq",2);
        System.out.println(testOverload.getAll("wrq",22,"sssssssssss"));
    }
}
