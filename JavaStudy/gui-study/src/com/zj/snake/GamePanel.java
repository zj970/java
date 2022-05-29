package com.zj.snake;

import javax.swing.*;
import java.awt.*;

//游戏的面板
public class GamePanel  extends JPanel {

    //绘制面板,游戏里的所有东西都是由此画笔制作
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏的作用，没有就会闪屏

        this.setBackground(Color.BLACK);
    }
}
