package com.zj.lesson6;

import com.zj.lesson5.JScrollDemo;

import javax.swing.*;
import java.awt.*;

//文本域
public class TestTextDemo03 extends JFrame {
    public TestTextDemo03() throws HeadlessException {
        Container container = this.getContentPane();
        //文本域
        JTextArea jTextArea = new JTextArea(20,50);
        jTextArea.setText("好好学习，天天向上");

        //Scroll面板
        JScrollPane scrollPane = new JScrollPane(jTextArea);
        container.add(scrollPane);
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo03();
    }
}
