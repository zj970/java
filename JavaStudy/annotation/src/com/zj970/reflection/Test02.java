package com.zj970.reflection;

/**
 * <p>
 * 什么叫反射
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/3
 */
public class Test02 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.zj970.reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("com.zj970.reflection.User");
        Class c3 = Class.forName("com.zj970.reflection.User");
        Class c4 = Class.forName("com.zj970.reflection.User");
        Class c5 = Class.forName("com.zj970.reflection.User");

        //一个类在内存中只有一个class对象
        //一个类被加载后，类的整个节后都会被封装在class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
        System.out.println(c5.hashCode());
    }
}


//实体类:pojo,entity
class User {
    private String name;
    private int id;
    private int age;

    public User() {

    }

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}