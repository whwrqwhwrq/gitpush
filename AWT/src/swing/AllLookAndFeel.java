package swing;

import javax.swing.*;

public class AllLookAndFeel {
    public static void main(String[] args) {
        System.out.println("当前系统所有可用的Look and Feel");

        UIManager.LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo installedLookAndFeel : installedLookAndFeels) {
            System.out.println(installedLookAndFeel.getName()+"---->"+installedLookAndFeel);
        }
    }
}
