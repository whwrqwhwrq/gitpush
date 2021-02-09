package awt;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SimpleMenu {
    private Frame frame = new Frame("菜单");
    private MenuBar menuBar = new MenuBar();
    Menu file = new Menu("文件");
    Menu edit = new Menu("编辑");
    Menu format = new Menu("格式");

    MenuItem create = new MenuItem("新建");
    MenuItem save = new MenuItem("保存");
    MenuItem exit = new MenuItem("退出", new MenuShortcut(KeyEvent.VK_X));

    CheckboxMenuItem autoSwitchLine = new CheckboxMenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");

    MenuItem commets = new MenuItem("注释", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelCommets = new MenuItem("取消注释");

    private TextArea textArea = new TextArea(5, 60);

    public void init() {
        ActionListener actionListener = e -> {
            String actionCommand = e.getActionCommand();
            textArea.append("单击了“" + actionCommand + "“按钮");
            if (actionCommand.equals("退出")) {
                System.out.println("程序退出");
                System.exit(0);
            }
        };
        commets.addActionListener(actionListener);
        exit.addActionListener(actionListener);

        file.add(create);
        file.add(save);
        file.add(exit);

        edit.add(autoSwitchLine);
        edit.addSeparator();
        edit.add(copy);
        edit.add(paste);
        edit.add(new MenuItem("-"));
        edit.add(format);

        format.add(commets);
        format.add(cancelCommets);

        menuBar.add(file);
        menuBar.add(edit);

        frame.setMenuBar(menuBar);
        frame.add(textArea);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("程序退出");
                System.exit(0);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }




    public static void main(String[] args) {
        new SimpleMenu().init();
    }
}
