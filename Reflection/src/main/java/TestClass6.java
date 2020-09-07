import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class TestClass6 {
    public static void test1(Map<Integer,Object> map, List<Student> list) {
        System.out.println("test1");
    }

    public static Map<String, String> test2() {
        System.out.println("test2");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<? extends TestClass6> c = TestClass6.class;
        Method test1 = c.getDeclaredMethod("test1", Map.class, List.class);
        Type[] genericParameterTypes = test1.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
        Method test2 = c.getDeclaredMethod("test2", null);
        Type genericReturnType = test2.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
