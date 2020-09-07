package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;//长度
    int[] snakeX = new int[600];//x坐标
    int[] snakeY = new int[500];//y坐标
    //头部方向
    String direction;
    //是否开始
    boolean isStart;
    //定时器

    Timer timer = new Timer(100, this);
    //构造器调用初始化方法
    public GamePanel() {
        init();

    }

    public void init() {
        length = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;

        snakeX[1] = 75;
        snakeY[1] = 100;

        snakeX[2] = 50;
        snakeY[2] = 100;

        direction = "right";
        isStart = false;

        setFocusable(true);//键盘焦点聚集在面板上
        addKeyListener(this);//添加监听器
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g/*代表一支画笔*/) {
        super.paintComponent(g);
        Color color = new Color(255, 255, 255);
        setBackground(color);
        //绘制头部图片
        Data.head.paintIcon(this,g,20,11);
        //绘制游戏区域
        g.fillRect(20,75,850,600);
        if (direction.equals("right")) {
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        } else if (direction.equals("left")) {
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);

        }else if (direction.equals("up")) {
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);

        }else{
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);

        }

        for (int i = 1; i < length; i++) {
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);

        }
        if (!isStart) {
            g.setColor(color);//设置画笔颜色
            g.setFont(new Font("微软雅黑",Font.BOLD,50));
            g.drawString(Data.startTitle,300,300);
        }

    }

    //监听键盘事件


    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {//键盘按下，未弹起
        //获取按下的是哪个键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {
            isStart = !isStart;
            repaint();
        }
        //键盘控制走向
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction = "left";
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction = "right";

        }else if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction = "up";

        }else {
            direction = "down";
        }
    }


//定时器，监听时间，帧
//执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart){

            for (int i = length - 1; i > 0 ; i--) {
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            if (direction.equals("right")) {
                snakeX[0] += 25;
                //边界判断
                if (snakeX[0] > 850) {
                    snakeX[0] = 100;
                }
            } else if (direction.equals("left")) {
                snakeX[0] -= 25;
                //边界判断
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (direction.equals("up")) {
                snakeY[0] -= 25;
                //边界判断
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else {
                snakeY[0] += 25;
                //边界判断
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }

            //刷新界面
            repaint();
        }
       timer.start(); //定时器启动
    }

}
