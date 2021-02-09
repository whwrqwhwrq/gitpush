class clazz {
    String name;
    {
        name = "A";
        if (name.equals("A")) {
            System.out.println("初始化块的变量初始化成功");
        } else {
            System.out.println("初始化块的变量初始化失败");
        }
    }
    public clazz(String name) {
        this.name = name;
    }


}




public class InitBlockTest {
    public static void main(String[] args) {
        clazz clazz = new clazz("6345gfdgdfgdf");
        Integer integer = new Integer("3");
        Integer i = Integer.parseInt("3");
        System.out.println(i);
        System.out.println(integer);

        String f = "3.2323";
        float ff = 3.2323f;
        String s = Float.toString(ff);
        Float aFloat = Float.valueOf(f);
        System.out.println(s+"\t"+aFloat);
    }
}
