package com.zj.lesson4;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo02 {
    public static void main(String[] args) {
        new MyJframe2().init();
    }
}
class MyJframe2 extends JFrame{
    public void init(){
        this.setBounds(10,10,200,200);
        this.setVisible(true);
        //设置文字 Jlabel
        JLabel jLabel = new JLabel("hello,world");
        this.add(jLabel);
        //让文本居中
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //获得一个容器
        Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.BLUE);
    }
}
