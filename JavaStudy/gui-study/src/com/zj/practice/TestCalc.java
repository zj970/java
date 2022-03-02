package com.zj.practice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//简易计算器
public class TestCalc {
    public static void main(String[] args) {

        new Calcuator().LoadFrame();
    }
}
//计算器类
class Calcuator extends Frame{

    //三个文本框
    TextField textField1 = new TextField(10);//字符数
    TextField textField2 = new TextField(10);
    TextField textField3 = new TextField(20);

    public void LoadFrame(){

        //1 个按钮
        Button button = new Button("=");
        button.addActionListener(new MyCalculatorListener());
        //1个标签
        Label label = new Label("+");

        //布局
        setLayout(new FlowLayout());//流式布局

        add(textField1);
        add(label);
        add(textField2);
        add(button);
        add(textField3);

        pack();;
        setVisible(true);
    }
    //监听器类
    private class MyCalculatorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            //1.获得加数和被加数
            int n1 = Integer.parseInt(textField1.getText());
            int n2 = Integer.parseInt(textField2.getText());

            //2.将结果放在第三个框
            textField3.setText(""+(n1+n2));

            //3.消除前面两个框
            textField1.setText("");
            textField2.setText("");
        }
    }
}
