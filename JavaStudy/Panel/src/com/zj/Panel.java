package com.zj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Panel {
    public void selectShape() throws Exception{
        System.out.println("请输入形状类型(数字)");

        //从控制台读取用户输入形状类型
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int shapeType = Integer.parseInt(input.readLine());

        //获得形状实例
        Shape shape = ShapeFactory.getShape(shapeType);

        if (shape == null){
            System.out.println("输入的形状不存在");
        }
        else {
            shape.draw();
        }
    }

    public static void main(String[] args)throws Exception {
        new Panel().selectShape();
    }
}
