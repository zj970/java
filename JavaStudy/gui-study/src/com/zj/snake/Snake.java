package com.zj.snake;

//贪吃蛇基本类
public class Snake {
    //定义蛇的数据结构
    int length;//蛇的长度
    int[] snakex = new int[600];//蛇的x坐标 25*25
    int[] snakey = new int[500];//蛇的y坐标 25*20

    String fx;//初始化的方向

    //初始化方法
    public void init(){
        length = 3;
        snakex[0] = 100;snakey[0] = 100;//脑袋的坐标
        snakex[1] = 75;snakey[1] = 100;//第一个身体的坐标
        snakex[2] = 50;snakey[2] = 100;//第二个身体的坐标
        fx = "D";
    }

    public Snake(){
        init();
    }
}
