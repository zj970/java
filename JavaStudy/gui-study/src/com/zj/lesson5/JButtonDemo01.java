package com.zj.lesson5;
import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo01 extends JFrame {
    public JButtonDemo01(){
        Container container = this.getContentPane();
        //将图片变成图标
        URL resource = JButtonDemo01.class.getResource("tx.jpg");//这里报异常，重启一下IDEA
        //URL url = ImageIconTest.class.getResource("tx.jpg");
        Icon icon = new ImageIcon(resource);
        //把这个图标放在按钮上
        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");
        //add
        container.add(button);
        this.setVisible(true);
        this.setSize(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JButtonDemo01();
    }
}
