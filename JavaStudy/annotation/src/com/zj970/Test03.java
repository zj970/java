package com.zj970;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *  自定义注解
 * </p>
 *
 * @author: zj970
 * @date: 2023/1/30
 */
public class Test03{
    /**
     *
     */
    @MyAnnotation2(name = "zj970")
    public void test(){

    }

}
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    /**
     * 注解的参数：参数类型+参数名()
     * @return
     */
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools() default {"贵阳大学","贵州数字科技大学"};
}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
