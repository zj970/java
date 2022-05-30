package com.zj.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//游戏的面板  //键盘监听器
public class GamePanel  extends JPanel implements KeyListener {
    //游戏当前的状态
    boolean isStart = false;//默认是不开始
    //绘制面板,游戏里的所有东西都是由此画笔制作
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏的作用，没有就会闪屏
        //绘制静态的面板
        this.setBackground(Color.WHITE);
        Data.header.paintIcon(this,g,25,11);//头部广告栏
        g.fillRect(25,75,850,600);//默认的游戏界面

        //把小蛇画上去
        snake snake = new snake();
        //方向
        switch (snake.fx){
            case "W": Data.up.paintIcon(this,g,snake.snakex[0],snake.snakey[0]); break;
            case "A": Data.left.paintIcon(this,g,snake.snakex[0],snake.snakey[0]); break;
            case "S": Data.down.paintIcon(this,g,snake.snakex[0],snake.snakey[0]); break;
            case "D": Data.right.paintIcon(this,g,snake.snakex[0],snake.snakey[0]); break;
        }

        for (int i = 1; i< snake.length;i++){
            Data.body.paintIcon(this,g,snake.snakex[i],snake.snakey[i]);//画身体部分
        }

        //游戏未开始时
        if (isStart == false){
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));//设置字体
            g.drawString("按下快捷键开始游戏",300,300);
        }
    }

    public GamePanel(){
        this.setFocusable(true);//获得焦点事件
        this.addKeyListener(this);//获得键盘的监听事件
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键盘按下
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();//获得键盘按键是哪一个
        if (keyCode == KeyEvent.VK_SPACE){
            //按下的空格
            isStart = !isStart;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


