package com.zebin.view;

import javax.swing.*;
import java.awt.*;

public class StringComponent extends JComponent {
    private static final int MESSAGE_X = 40;
    private static final int MESSAGE_Y = 30;

    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 50;
    public StringComponent(){

    }
    public void paintComponent(Graphics g){
        //设置字体大小
        Font font = new Font("SansSerif", Font.BOLD, 16);
        g.setFont(font);
        //设置字体颜色
        g.setColor(Color.blue);
        //绘制字体
        g.drawString("Welcome to Tomato Clock!",MESSAGE_X,MESSAGE_Y);
    }
    //设置组件大小
    public Dimension getPreferredSize(){
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension size = toolkit.getScreenSize();
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
