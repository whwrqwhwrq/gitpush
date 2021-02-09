package javaFrequentlyUsedClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("a", "A");
        properties.setProperty("b", "B");
        properties.setProperty("c", "C");
        properties.store(new FileOutputStream("a.ini"), "storing properties");

        Properties properties2 = new Properties();
        properties2.setProperty("d", "D");
        properties2.load(new FileInputStream("a.ini"));
        System.out.println(properties2);
    }
}
