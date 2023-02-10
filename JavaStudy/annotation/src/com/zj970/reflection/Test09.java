package com.zj970.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <p>
 *  动态创建对象执行方法
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/10
 */
public class Test09 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.zj970.reflection.User");

        //构造一个对象
        User user = (User) c1.newInstance();
        System.out.println("user = " + user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class,int.class);
        User user1 = (User) constructor.newInstance("zj970",001,24);
        System.out.println("user1 = " + user1);

        //通过反射调用普通方法
        User user2 = (User) c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke: 激活
        //对象，"方法的值"
        setName.invoke(user2,"zj970");
        System.out.println(user2.getName());

        //通过反射操作属性
        User user3 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性，我们需要关闭程序的安全检测，属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user3,"zj970");
        System.out.println("user3.getName() = " + user3.getName());
    }

}
