package com.zj970.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * <p>
 * 练习ORM
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/13
 */
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c = Class.forName("com.zj970.reflection.Student_2");
        
        //通过反射获得注解
        Annotation[] annotations = c.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }

        //获得注解的value的值
        System.out.println("===============================");
        MyTable table = (MyTable) c.getAnnotation(MyTable.class);
        String value = table.value();
        System.out.println("value = " + value);

        //获得类指定的注解
        System.out.println("===============================");
        Field f = c.getDeclaredField("name");
        MyField myField = f.getAnnotation(MyField.class);
        System.out.println("myField.toString() = " + myField.toString());
    }

}

/**
 * entity-----student
 */
@MyTable("student_table")
class Student_2 {
    @MyField(columnName = "student_id", type = "int", length = 10)
    private int id;
    @MyField(columnName = "student_age", type = "int", length = 10)

    private int age;
    @MyField(columnName = "student_name", type = "varchar", length = 10)

    private String name;

    @Override
    public String toString() {
        return "Student_2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    Student_2() {

    }

    Student_2(int id, int age, String name) {
        this.id = id;
        this.age = age;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTable {
    String value();
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyField {
    /**
     * 字段名
     *
     * @return
     */
    String columnName();

    /**
     * 字段类型
     *
     * @return
     */
    String type();

    /**
     * 字段长度
     *
     * @return
     */
    int length();
}