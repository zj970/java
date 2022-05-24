package com.zj.lesson6;

import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo01 extends JFrame {
    public TestComboboxDemo01(){
        Container container = this.getContentPane();
        JComboBox status = new JComboBox();
        status.addItem(null);//项数为-1
        status.addItem("正在上映");//为0
        status.addItem("已下架");
        status.addItem("即将上映");
        status.setSize(200,200);
        status.setBackground(Color.black);
        status.setVisible(true);
        //监听
        //status.addActionListener();
        //status.addItemListener();
        System.out.println(status.getSelectedIndex());//返回项数
        System.out.println(status.getSelectedItem());//返回内容
        container.add(status,BorderLayout.CENTER);
        //this.add(container);
        this.setSize(500,350);
        this.setVisible(true);
        status.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestComboboxDemo01();
    }
}
