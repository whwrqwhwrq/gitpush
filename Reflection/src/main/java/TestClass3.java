import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestClass3 {
    //获得 类的信息
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        //获得类名
        Class<?> student = Class.forName("Student");
        System.out.println(student.getName());
        System.out.println(student.getSimpleName());
        //获得类的public属性
        Field[] fields = student.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i]);
        }
        //获得类的所有属性
        Field[] declaredFields = student.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i]);
        }
        //获得指定属性
        Field gender = student.getDeclaredField("gender");
        System.out.println(gender);

        //获得本类及父类的所有public方法
        Method[] methods = student.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        //获得本类的所有方法
        Method[] declaredMethods = student.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        //获得指定方法
        Method getGender = student.getMethod("getGender", null);
        Method setGender = student.getMethod("setGender", String.class);
        System.out.println(getGender);
        System.out.println(setGender);
        //获得指定的构造器
        Constructor<?>[] constructors = student.getConstructors();
        Constructor<?>[] declaredConstructors = student.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }
}
