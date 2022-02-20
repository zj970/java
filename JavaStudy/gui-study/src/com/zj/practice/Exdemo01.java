package com.zj.practice;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//联系frame,panel,button，布局
public class Exdemo01 {
    /*
    public static void main(String[] args) {
        //1.需要一个弹窗
        Frame frame = new Frame("练习题一");
        //2.弹窗的格式为2行1列
        frame.setLayout(new GridLayout(2,1));
        //3.需要4个面板panel和10个button
        Panel panel1 = new Panel(new BorderLayout());
        Panel panel2 = new Panel(new GridLayout(2,1));
        Panel panel3 = new Panel(new BorderLayout());
        Panel panel4 = new Panel(new GridLayout(2,2));

        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");
        Button button4 = new Button("button4");
        Button button5 = new Button("button5");
        Button button6 = new Button("button6");
        Button button7 = new Button("button7");
        Button button8 = new Button("button8");
        Button button9 = new Button("button9");
        Button button10 = new Button("button10");

        //4.细分构造面板，面板2，面板4分别为2行1列，2行两列
        panel2.setLayout(new GridLayout(2,1));
        panel4.setLayout(new GridLayout(2,4));
        //5.panel2储存button2,3.panel4储存button6,7,8,9
        panel2.add(button2);
        panel2.add(button3);

        panel4.add(button6);
        panel4.add(button7);
        panel4.add(button8);
        panel4.add(button9);
        //6.整合弹窗frame存储panel1,3
        frame.add(panel1);
        frame.add(panel3);
        //7.panel1,3使用BordLayout布局
        panel1.add(button1,BorderLayout.EAST);
        panel1.add(panel2,BorderLayout.CENTER);
        panel1.add(button4,BorderLayout.WEST);

        panel3.add(button5,BorderLayout.EAST);
        panel3.add(panel4,BorderLayout.CENTER);
        panel3.add(button10,BorderLayout.WEST);


        //8.设置可见，大小，事件监听
        frame.setSize(400,300);
        frame.setLocation(300,300);
        frame.setVisible(true);
        //frame.pack();//java 的函数 自动选择最优的布局,自动填充，不需要设置大小

       frame.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               super.windowClosing(e);
               System.exit(0);
           }
       });
        }*/



    //狂老师的代码
    public static void main(String[] args) {
        //总frame
        Frame frame = new Frame("练习题");
        frame.setSize(400,300);
        frame.setLocation(300,400);
        frame.setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(2,1));

        //4个面板
        Panel panel1 = new Panel(new BorderLayout());
        Panel panel2 = new Panel(new GridLayout(2,1));
        Panel panel3 = new Panel(new BorderLayout());
        Panel panel4 = new Panel(new GridLayout(2,2));

        //上面
        panel1.add(new Button("East-1"),BorderLayout.EAST);
        panel1.add(new Button("West-1"),BorderLayout.WEST);
        panel2.add(new Button("p2-btn-1"));
        panel2.add(new Button("p2-btn-2"));
        panel1.add(panel2,BorderLayout.CENTER);

        //下面
        panel3.add(new Button("East-2"),BorderLayout.EAST);
        panel3.add(new Button("West-2"),BorderLayout.WEST);
        for (int i = 0; i < 4; i++) {
            panel4.add(new Button("for-"+i));
        }
        panel3.add(panel4);
        frame.add(panel1);
        frame.add(panel3);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
//布局声明，一开始声明面板的时候就必须申明布局格式
}
