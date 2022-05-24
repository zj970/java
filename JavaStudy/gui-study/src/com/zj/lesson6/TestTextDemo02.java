package com.zj.lesson6;

import javax.swing.*;
import java.awt.*;
//密码框
public class TestTextDemo02 extends JFrame {
    public TestTextDemo02() throws HeadlessException {
        Container container = this.getContentPane();

        //面板制作，不用
        JPasswordField jTextField = new JPasswordField();//***
        jTextField.setEchoChar('*');
        container.add(jTextField,BorderLayout.NORTH);
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestTextDemo02();
    }
}
