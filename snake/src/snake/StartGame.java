package snake;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        //绘制一个静态窗口
        JFrame frame = new JFrame();
        frame.setTitle("my snake");
        frame.setResizable(false);
        frame.setBounds(500, 100, 900, 720);
        frame.setDefaultCloseOperation(3);

        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);
        frame.setVisible(true);
    }
}
