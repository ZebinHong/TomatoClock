package com.zebin.service;

import com.zebin.view.SimpleFrame;
import com.zebin.view.TakeTime;

import javax.swing.*;
import java.awt.*;

public class WindowService {

    public static void main(String[] args) {
        //获取所有字体名称
//        String[] fontNames= GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for(String name:fontNames){
//            System.out.println(name);
//        }
        EventQueue.invokeLater(()->{
            SimpleFrame frame = new SimpleFrame();
//            Component c = new MyComponent();
//            frame.add(c);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
