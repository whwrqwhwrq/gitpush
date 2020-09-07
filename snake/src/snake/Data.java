package snake;

import javax.swing.*;
import java.net.URL;

//获取各种资源
public class Data {
    public static URL headUrl = Data.class.getResource("../staticResource/header.png");
    public static URL bodyUrl = Data.class.getResource("../staticResource/body.png");
    public static URL upUrl = Data.class.getResource("../staticResource/up.png");
    public static URL downUrl = Data.class.getResource("../staticResource/down.png");
    public static URL leftUrl = Data.class.getResource("../staticResource/left.png");
    public static URL rightUrl = Data.class.getResource("../staticResource/right.png");
    public static URL foodUrl = Data.class.getResource("../staticResource/food.png");
    public static ImageIcon head = new ImageIcon(headUrl);
    public static ImageIcon body = new ImageIcon(bodyUrl);
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);
    public static ImageIcon food = new ImageIcon(foodUrl);
    public static String startTitle = "按下空格开始";

}
