import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射动态创建对象
public class TestClass4 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> studentC = Class.forName("Student");
        Student student = (Student) studentC.newInstance();//本质是调用 了  无参构造器
        System.out.println(student);

        //通过构造器创建对象
        Constructor<?> declaredConstructor = studentC.getDeclaredConstructor(String.class, String.class, String.class);
        Student student1 = (Student) declaredConstructor.newInstance("Fuyx","男","人大附中");
        System.out.println(student1);
        //通过反射调用方法
        Student student3 = (Student) studentC.newInstance();
        Method setName = studentC.getDeclaredMethod("setName", String.class);
        setName.invoke(student3, "MGK");
        System.out.println(student3);

        //通过反射操作属性
        Student student4 = (Student) studentC.newInstance();
        Field school = studentC.getDeclaredField("school");
        school.setAccessible(true);//取消安全检查
        school.set(student4,"求实中学");
        System.out.println(student4);

    }
}
