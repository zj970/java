package com.zj.snake;

import javax.swing.*;

//游戏的主启动类
public class StartGame {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();

        jFrame.setBounds(10,10,915,700);//根据图片算出的大小，固定窗口大小，不允许拉伸
        jFrame.setResizable(false);//窗口大小不可变
        //正常的游戏都在游戏的面板上
        GamePanel gamePanel = new GamePanel();
        jFrame.add(gamePanel);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
