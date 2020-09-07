import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class Reflection_2 {
    //都有哪些类型 有 CLASS
    public static void main(String[] args) {
        Class<Object> objectClass = Object.class;//对象
        Class<Comparable> comparableClass = Comparable.class;//接口
        Class<String[]> aClass = String[].class;//一维数组
        Class<float[][]> aClass1 = float[][].class;//二维数组
        Class<Integer> integerClass = int.class;//基本数据类型
        Class<Target> targetClass = Target.class;//注解
        Class<ElementType> elementTypeClass = ElementType.class;//枚举
        Class<Void> voidClass = void.class;//空
        Class<Class> classClass = Class.class;//Class

        Object[] objects={objectClass,comparableClass,aClass,aClass1,integerClass,targetClass,elementTypeClass,voidClass,classClass};
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
    }
}
