package com.zj.lesson1;

import java.awt.*;

//GUI的第一个界面
public class TestFrame {

    public static void main(String[] args) {
        //Frame
        Frame frame = new Frame("我的第一个java图像窗口");

        //需要设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(400,400);

        //设置背景颜色
        frame.setBackground(new Color(72, 187, 32));

        //弹出的初始位置
        frame.setLocation(200,200);

        //设置大小固定
        frame.setResizable(false);
    }
}
