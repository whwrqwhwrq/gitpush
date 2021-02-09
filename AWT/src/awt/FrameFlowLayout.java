package awt;

import java.awt.*;

public class FrameFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("流式布局的frame");

        frame.setBounds(10,10,300,200);

        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 10);
        frame.setLayout(flowLayout);
        for (int i = 0; i < 20; i++) {
            frame.add(new Button("第" + (i + 1) + "个标签"));
        }

        frame.setVisible(true);
    }
}
