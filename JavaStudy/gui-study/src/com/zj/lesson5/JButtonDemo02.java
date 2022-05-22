package com.zj.lesson5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
public class JButtonDemo02 extends JFrame {
    public JButtonDemo02(){
        Container container = this.getContentPane();
        //将图片变成图标
        URL resource = JButtonDemo02.class.getResource("tx.jpg");//这里报异常，重启一下IDEA
        //URL url = ImageIconTest.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(resource);
        //弄一个单选框
        JRadioButton jRadioButton1 = new JRadioButton("jRadioButton1");
        JRadioButton jRadioButton2 = new JRadioButton("jRadioButton2");
        JRadioButton jRadioButton3 = new JRadioButton("jRadioButton3");

        //单选框只能选择一个，分组,不分组可以多选
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);
        //add
        container.add(jRadioButton1,BorderLayout.CENTER);
        container.add(jRadioButton2,BorderLayout.NORTH);
        container.add(jRadioButton3,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
