package com.zj.lesson3;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}
class MyPaint extends Frame{
    public void loadFrame(){
        setBounds(200,200,600,600);
        setVisible(true);
    }

    //画笔
    @Override
    public void paint(Graphics g) {

        //super.paint(g);有些父类可以直接注释
        //画笔，需要有颜色，画笔可以画画
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
        g.setColor(Color.green);
        g.fillOval(200,200,50,50);
        g.setColor(Color.black);
        g.fillRect(300,300,10,10);
        //养成习惯，画笔用完，将他还原到最初的颜色----黑色
    }
}