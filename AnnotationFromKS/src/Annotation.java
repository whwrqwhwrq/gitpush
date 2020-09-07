import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@MyAnnotation(d = {"j","e","d","a","r","0","k"})
//如果没有默认值，则必须给注解赋值
public class Annotation {
    @one("kkkkkksskssksksksksks")
    void mmmmm() {

    }
}

@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    String a() default "";
    int b() default 6;
    int c() default -2;
    String[] d();
}
@Target(value = ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface one {
    String value();
}