package javaBaseLib;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

public class SystemEnvVar {
    public static void main(String[] args) throws IOException {
        Map<String, String> getenv = System.getenv();
        List<String> SystemVar = getenv.entrySet().stream().map(item -> item.getValue()).collect(Collectors.toList());
        SystemVar.stream().forEach(System.out::println);

        String java_home = System.getenv("JAVA_HOME");
        System.out.println("java系统环境变量是".concat(java_home));

        Properties properties = System.getProperties();
        properties.store(new FileOutputStream("systemProperties.txt"), "System Properties");

    }
}
