package javaFrequentlyUsedClass;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("竹外桃花三两枝，春江水暖鸭先知");
        sb.append("正是河豚欲上时");
        sb.replace(7, 8, "。");
        sb.reverse();
        String s = sb.toString();
        System.out.println(s);
        System.out.println(sb);

        System.out.println(sb.length());
        System.out.println(sb.capacity());
    }
}
