package javaBaseLib;

import java.io.File;
import java.util.Scanner;

public class ScannerFile {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("ScannerFile.java"));
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
