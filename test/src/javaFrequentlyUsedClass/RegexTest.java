package javaFrequentlyUsedClass;

public class RegexTest {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc一二三");
        String s = stringBuilder.toString();
        String s1 = s.replaceFirst("\\w*", "○");
        System.out.println(s1);
        String s2 = s.replaceFirst("\\w*?", "○");
        System.out.println(s2);



    }
}
