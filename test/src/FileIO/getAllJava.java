package FileIO;

import java.io.File;

/**
 * @Author:wrq
 * @Date:2020/10/30 9:54
 */
public class getAllJava {
    public static void main(String[] args) {
        File file = new File(".");
        String[] list = file.list((dir, name) -> name.endsWith(".ini") || new File(name).isDirectory());
        for (String s : list) {
            System.out.println(s);

        }

    }
}
