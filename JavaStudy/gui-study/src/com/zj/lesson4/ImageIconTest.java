package com.zj.lesson4;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconTest extends JFrame {
    public ImageIconTest() throws HeadlessException {
        //获取图片的地址
        JLabel label = new JLabel("ImageIcon");
        URL url = ImageIconTest.class.getResource("tx.jpg");
        ImageIcon imageIcon = new ImageIcon(url);
        label.setIcon(imageIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        Container contentPane = getContentPane();
        contentPane.add(label);
        this.setBounds(100,100,500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageIconTest();
    }
}
