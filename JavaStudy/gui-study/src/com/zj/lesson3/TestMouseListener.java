package com.zj.lesson3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

//鼠标监听事件
public class TestMouseListener {
    public static void main(String[] args) {
        new MyFrame("画画");
    }
}

//自己的类
class MyFrame extends Frame{
    //画画需要画笔，需要监听鼠标当前位置，需要集合来存储这个点
    ArrayList points;
    public MyFrame(String title) {
        super(title);
        setBounds(200, 200, 400, 400);

        //存鼠标点击点
        points = new ArrayList<>();

        //鼠标监听器，正对这个窗口
        this.addMouseListener(new MyMouseListener());

        setVisible(true);
    }
        @Override
        public void paint(Graphics g) {
            //画画，监听鼠标的事件
            Iterator iterator = points.iterator();
            while (iterator.hasNext()){
                Point point = (Point) iterator.next();
                g.setColor(Color.cyan);
                g.fillOval(point.x,point.y,10,10);
            }
        }
        //添加一个点到界面上去
        public void addPaint(Point point){
            points.add(point);
        }


        //适配器模式
        private class MyMouseListener extends MouseAdapter{
            //鼠标按下不放

            @Override
            public void mousePressed(MouseEvent e) {
                MyFrame myFreame = (MyFrame) e.getSource();
               //TODO :这里我们点击的时候，就会在界面产生一个点
                // 这个点就是鼠标的点
                myFreame.addPaint(new Point(e.getX(),e.getY()));
                //每次点击鼠标都需要重新画一遍
                myFreame.repaint();
            }
        }

}