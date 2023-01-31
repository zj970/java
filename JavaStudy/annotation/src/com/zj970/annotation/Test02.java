package com.zj970.annotation;

import java.lang.annotation.*;

/**
 * <p>
 *  测试元注解
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/28
 */
public class Test02 {
    @MyAnnotation
    public void test(){

    }
}

/**
 * 定义一个注解
 * @Target表示我们的注解可以用在哪些地方，通过ElementType枚举
 *
 * @Retention表示我们的注解在什么地方有效 runtime>class>source
 *
 * @Documented 表示是否将我们的注解生成在JAVA Doc文档中
 *
 * @Inherited 子类可以继承父类的注解
 */
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Inherited
@interface MyAnnotation{

}
