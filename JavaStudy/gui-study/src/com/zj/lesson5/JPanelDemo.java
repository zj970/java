package com.zj.lesson5;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {

    public JPanelDemo(){
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(2,1,10,10));//后面参数的意思就是间距

        JPanel jPanel = new JPanel(new GridLayout(1,3));
        JPanel jPanel1 = new JPanel(new GridLayout(2,1));
        JPanel jPanel2 = new JPanel(new GridLayout(2,3));
        JPanel jPanel3 = new JPanel(new GridLayout(1,1));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("1"));
        jPanel.add(new JButton("1"));
        jPanel1.add(new JButton("2"));
        jPanel1.add(new JButton("2"));
        jPanel2.add(new JButton("3"));
        jPanel2.add(new JButton("3"));
        jPanel2.add(new JButton("3"));
        jPanel2.add(new JButton("3"));
        jPanel2.add(new JButton("3"));
        jPanel2.add(new JButton("3"));
        jPanel3.add(new JButton("4"));
        this.setVisible(true);
        //this.setBounds(50,50,400,400);
        container.add(jPanel);
        container.add(jPanel1);
        container.add(jPanel2);
        container.add(jPanel3);
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
