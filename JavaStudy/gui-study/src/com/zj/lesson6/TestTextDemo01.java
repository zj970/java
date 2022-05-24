package com.zj.lesson6;

import javax.swing.*;
import java.awt.*;

//文本框
public class TestTextDemo01 extends JFrame
{
    public TestTextDemo01() throws HeadlessException {
        Container container = this.getContentPane();


        JTextField jTextField = new JTextField("hello");
        JTextField jTextField2 = new JTextField("world",20);
        container.add(jTextField,BorderLayout.NORTH);
        container.add(jTextField2,BorderLayout.SOUTH);
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo01();
    }
}
