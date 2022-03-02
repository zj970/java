package com.zj.lesson2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTextField {
    public static void main(String[] args) {
        //服务器应该只有一个启动类
        new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);
        //监听这个文本框输入的文字
        MyActionLictener myActionLictener = new MyActionLictener();
        //按下Enter就会触发这个事件
        textField.addActionListener(myActionLictener);
        //设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}
class MyActionLictener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        e.getSource();//获得一些资源

        TextField field = (TextField) e.getSource();
        System.out.println(field.getText());//获得文本框输入的文本
        //每次输入清空
        field.setText("");//null.""
    }
}