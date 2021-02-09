package javaFrequentlyUsedClass;

public class StringToBytes {
    public static void main(String[] args) {
        String s = "newstring新的字符串";
        byte[] bytes = s.getBytes();
        System.out.println(bytes.length);
        for (byte b : bytes) {
            System.out.println(b);
        }
        System.out.println("__________________________________________");
        char[] chars = s.toCharArray();
        System.out.println(chars.length);
        for (char aChar : chars) {
            System.out.println(aChar);
        }
    }
}
