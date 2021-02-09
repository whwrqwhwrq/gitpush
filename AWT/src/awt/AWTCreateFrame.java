package awt;

import java.awt.*;

public class AWTCreateFrame {
    private static int width;
    private static int height;
    public static void main(String[] args) {
        width = 600;
        height = 400;

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = defaultToolkit.getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        Frame frame = new Frame();
        frame.setTitle("My First Frame");
        frame.setBounds(screenWidth / 2 - width / 2, screenHeight / 2 - height / 2, width, height);

        frame.setVisible(true);

    }
}
