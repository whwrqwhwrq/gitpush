package awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameGridLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new GridLayout(5, 6));
        for (int i = 0; i < 20; i++) {
            frame.add(new Button(String.valueOf((i+1))));
        }
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("窗口被关闭");
                System.exit(0);
            }
        });
    }
}
