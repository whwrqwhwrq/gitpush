import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class TestClass7 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class userC = Class.forName("User");
        Annotation[] declaredAnnotations = userC.getDeclaredAnnotations();
        for (Annotation declaredAnnotation : declaredAnnotations) {
            System.out.println(declaredAnnotation);
        }
        //获得注解的value的值
        J j = (J)userC.getAnnotation(J.class);
        String value = j.value();
        System.out.println(value);

        Field id = userC.getDeclaredField("id");
        field f = id.getAnnotation(field.class);
        System.out.println(f.columnName());
        System.out.println(f.length());
        System.out.println(f.type());
    }
}
@J("db.student")
class User {
    @field(columnName = "id",type = "int" ,length = 3)
    private int id;
    @field(columnName = "name",type = "String" ,length = 10)
    private String name;
    @field(columnName = "age",type = "int" ,length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface J {
    String value();
}
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface field{
    String columnName();

    String type();

    int length();
}