package com.zj970.reflection;

/**
 * <p>
 * 测试类什么时候初始化
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/6
 */
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) {
        //1. 主动调用--->初始化只会调用一次
        Son son = new Son();
        System.out.println("-------------------------------");
        //反射也会产生主动引用
        try {
            Class.forName("com.zj970.reflection.Son");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------");

        //不会产生类引用的方法
        System.out.println(Son.n);
        System.out.println("-------------------------------");

        Son[] array = new Son[5];
        System.out.println("-------------------------------");

        System.out.println(Son.M);
    }
}
class Father{
    static int n = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}