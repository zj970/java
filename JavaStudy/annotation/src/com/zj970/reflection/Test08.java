package com.zj970.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * <p>
 * 获取类的运行时结构
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/7
 */
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.zj970.reflection.User");

        //获得类的名字
        //获得报名、类名
        System.out.println(c1.getName());
        System.out.println("获得类名：" + c1.getSimpleName());

        //获得类的属性
        System.out.println("================================================");
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println("getFields()只会找到public属性，但是可以找到父类的属性----》" + field);
        }

        System.out.println("================================================");
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("getDeclaredFields()会找到所有属性，但是可以找到继承类的属性----》" + field);
        }

        //获得指定属性，方法同上，类别同上
        System.out.println("================================================");
        ///Field name = c1.getField("name");private
        Field name1 = c1.getDeclaredField("name");
        //System.out.println(name);
        System.out.println(name1);

        //获得类的方法
        System.out.println("================================================");
        Method[] methods = c1.getMethods();
        for (Method method : methods){
            System.out.println("getMethods()同getField()一样-----》" + method);
        }


        System.out.println("================================================");
        methods = c1.getDeclaredMethods();
        for (Method method : methods){
            System.out.println("getDeclaredMethods()同getDeclaredField()一样-----》" + method);
        }

        //获得指定方法
        //重载
        System.out.println("================================================");
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);


        //获取指定的构造器
        System.out.println("================================================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println("getConstructors------->" + constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            System.out.println("getDeclaredConstructors------->" + constructor);
        }

        //获得指定构造器
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
        System.out.println(declaredConstructor);
    }
}
