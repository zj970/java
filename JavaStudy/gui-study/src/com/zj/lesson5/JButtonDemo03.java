package com.zj.lesson5;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo03 extends JFrame {
    public JButtonDemo03() {
        Container container = this.getContentPane();
        //将图片变成图标
        URL resource = JButtonDemo02.class.getResource("tx.jpg");//这里报异常，重启一下IDEA
        //URL url = ImageIconTest.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(resource);
        //弄一个多选框
        JCheckBox jCheckBox1 = new JCheckBox("jCheckBox1");
        JCheckBox jCheckBox2 = new JCheckBox("jCheckBox2");
        JCheckBox jCheckBox3 = new JCheckBox("jCheckBox3");

        container.add(jCheckBox1,BorderLayout.CENTER);
        container.add(jCheckBox2,BorderLayout.NORTH);
        container.add(jCheckBox3,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(500, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JButtonDemo03();
    }
}
