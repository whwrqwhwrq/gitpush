import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass5 {
    public static void test1() {
        Student student = new Student();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            student.getGender();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
    public static void test2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        Class<?> student1 = Class.forName("Student");
        Method getGender = student1.getDeclaredMethod("getGender", null);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getGender.invoke(student);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test1();
        test2();

    }
}
