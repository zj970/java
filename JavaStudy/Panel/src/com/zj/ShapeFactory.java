package com.zj;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ShapeFactory {
    public static Properties shapes = new Properties();

    static {
        try {
            InputStream in = ShapeFactory.class.getResourceAsStream("/com/zj/panel.properties");
            shapes.load(in);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static Shape getShape(int type){
        try {
            //获得与形状类型相匹配的形状的类名
            String className = (String) shapes.get(String.valueOf(type));
            //运用Java的反射机制构造形状对象
            return (Shape) Class.forName("com.zj."+className).newInstance();//这里要指定好out的path
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
/**
 * ps:如果增加一个画三角形的功能，只要在panel.properties中增加一行
 * 4=Triangle,然后再创建一个继承Shape类的Triangle子类即可
 */