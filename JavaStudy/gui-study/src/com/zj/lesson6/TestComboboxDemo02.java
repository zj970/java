package com.zj.lesson6;

import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo02 extends JFrame {
    public TestComboboxDemo02(){
       //Container container = new Container();
        Container container = this.getContentPane();
        //生成列表的内容
        String[] contents = {"1","2","3"};
        //列表中需要放内容
        JList jList = new JList(contents);
        //Vector vector = new Vector();
        //JList jList1 = new JList(vector);
        //vector.add("1");
        //vector.add("12");
        //vector.add("13");
        container.add(jList);
        //container.add(jList1);
        container.setVisible(true);
        this.add(jList);
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new TestComboboxDemo02();
    }
}
