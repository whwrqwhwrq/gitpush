package javaBaseLib;

public class IdentityHashCodeTest {
    public static void main(String[] args) {
        String s = new String("jedar");
        String s1 = new String("jedar");
        System.out.print("两个字符串对象的hashcode是否相等");
        System.out.println(s.hashCode() == s1.hashCode());
        System.out.print("两个字符串对象的identityhashcode是否相等");
        System.out.println(System.identityHashCode(s) == System.identityHashCode(s1));

    }
}
