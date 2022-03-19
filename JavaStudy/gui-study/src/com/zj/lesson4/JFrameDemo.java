package com.zj.lesson4;

import javax.swing.*;

public class JFrameDemo {
    //init();初始化
    public void init(){
        //顶级窗口
        JFrame jframe = new JFrame("这是一个JFrame窗口");
        jframe.setVisible(true);
        jframe.setBounds(100,100,200,200);

        //设置文字 Jlabel
        JLabel jLabel = new JLabel("hello,world");
        jframe.add(jLabel);

        //关闭事件
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
