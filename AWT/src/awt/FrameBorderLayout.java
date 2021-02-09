package awt;

import java.awt.*;

public class FrameBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        frame.setLayout(new BorderLayout(5, 10));
        frame.add(new Button("北"), BorderLayout.NORTH);
        frame.add(new Button("南"), BorderLayout.SOUTH);
        frame.add(new Button("中"), BorderLayout.CENTER);
        frame.add(new Button("东"), BorderLayout.EAST);
        frame.add(new Button("西"), BorderLayout.WEST);
        frame.pack();
        frame.setVisible(true);
    }
}
