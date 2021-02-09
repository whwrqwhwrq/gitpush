package generic;
class MyUtil <T>{
    public static <E> MyUtil<E> nil() {
        return null;
    }

    public static <E> MyUtil<E> cons(E head, MyUtil<E> myUtil) {
        return null;
    }

    T head() {
       return null;
    }
}
public class GenericInference {
    public static void main(String[] args) {
        MyUtil<String> nil = MyUtil.nil();
        MyUtil<Integer> cons = MyUtil.cons(23, MyUtil.nil());
    }
}
