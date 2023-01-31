package com.zj970.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  什么是注解
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/25
 */
public class Test01 extends Object {
    //@Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //废弃注解->不推荐程序员使用，但是可以使用，或者存在更好的方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    public static void main(String[] args) {
        Test01.test();
    }

    @SuppressWarnings("all")
    public void test02(){
        List list = new ArrayList();
    }
}
