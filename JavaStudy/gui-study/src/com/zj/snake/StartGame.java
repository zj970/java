package com.zj.snake;

import javax.swing.*;

//游戏的主启动类
public class StartGame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        jFrame.setBounds(10,10,900,700);//根据图片算出的大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
