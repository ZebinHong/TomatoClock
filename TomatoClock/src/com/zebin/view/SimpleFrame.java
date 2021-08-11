package com.zebin.view;


import javax.swing.*;
import java.awt.*;

public class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 500;
    //创建底部面板
    public static JPanel buttonPanel = new JPanel();
    //创建时间框
    public static JTextField field = null;
    //唯一的操作时间的对象
    public static TakeTime time = new TakeTime();


    public SimpleFrame() {
        //给JFrame盖上一层Jpanel边框布局面板
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        add(jpanel);
        //给面板设置初始颜色
        jpanel.setBackground(Color.PINK);
        buttonPanel.setBackground(Color.PINK);
        //获取屏幕大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        //设置窗体大小和位置
        setBounds(screenSize.width / 2 - 250, screenSize.height / 2 - 250, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setTitle("番茄时钟");
        //设置图标
        Image image = new ImageIcon("img/2.jpeg").getImage();
        setIconImage(image);
        //添加字符串组件
        jpanel.add(new StringComponent(), BorderLayout.NORTH);
        //pack();


        //添加字符串，用匿名内部类的方式
        buttonPanel.add(new JComponent() {
            public void paintComponent(Graphics g) {
                //设置字体大小
                Font font = new Font("SansSerif", Font.BOLD, 16);
                g.setFont(font);
                //设置字体颜色
                g.setColor(Color.black);
                //绘制字体
                g.drawString("change color:", 0, 14);
            }
            //设置组件的大小
            public Dimension getPreferredSize() {
                return new Dimension(110, 20);
            }
        });

        //设置改变背景色功能按钮
        makeColor("pink", Color.pink, jpanel);
        makeColor("black", Color.black, jpanel);
        makeColor("white", Color.white, jpanel);

        //添加底部面板到边框面板
        jpanel.add(buttonPanel, BorderLayout.SOUTH);
        //新建中间面板
        JPanel jpanel2 = new JPanel();
        jpanel.add(jpanel2);
        //添加文本框
        field = new JTextField(5);
        //设置文本框大小
        field.setPreferredSize(new Dimension(20,60));
        //设置字体大小
        Font font = new Font("SansSerif", Font.BOLD, 30);
        SimpleFrame.field.setFont(font);
        //设置文本框内容颜色
//        field.setForeground(Color.red);
        //设置是否可编辑
//        field.setEditable(false);
        //设置文本框内容排布方式
        field.setHorizontalAlignment(JTextField.CENTER);
        jpanel2.add(field);
        //添加启动按钮
        JButton startBtn = new JButton("start");
        jpanel2.add(startBtn);
        //给按钮添加监听器
        startBtn.addActionListener(event->{
            //启动计时器
            time.takeATomato();
        });

        //添加暂停按钮
//        JButton stopBtn = new JButton("stop");
//        jpanel2.add(stopBtn);
//        //给按钮添加监听器
//        stopBtn.addActionListener(event->{
//            //休眠
////            TakeTime.isPause = true;
////            try {
////                Thread.sleep(1000*60);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////            Object[] options ={ "取消", "继续" };
////            int m = JOptionPane.showOptionDialog(null, "是否取消暂停？",
////                    "暂停中",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
////            if(m==0)
////                TakeTime.isPause = false;
//            if(TakeTime.isPause == true){
//                TakeTime.isPause = false;
//            }else if(TakeTime.isPause == false){
//                TakeTime.isPause = true;
//            }
//        });
        //添加休息按钮
        JButton restBtn = new JButton("rest");
        jpanel2.add(restBtn);
        //给按钮添加监听器
        restBtn.addActionListener(event->{
            //休息
            time.resting();
        });

    }

    //改变面板背景色
    public void makeColor(String name, Color bgc, JPanel jpanel) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> {
            jpanel.setBackground(bgc);
            buttonPanel.setBackground(bgc);
        });
    }
}
