package com.zj970.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  获取泛型信息
 * </p>
 *
 * @author: zj970
 * @date: 2023/2/12
 */
public class Test11 {
    public void test01 (Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01", Map.class, List.class);
        Type[] genericExceptionTypes = method.getGenericParameterTypes();
        for (Type genericExceptionType : genericExceptionTypes) {
            System.out.println("genericExceptionType = " + genericExceptionType);
            if (genericExceptionType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericExceptionType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("actualTypeArgument = " + actualTypeArgument);
                }
            }
        }

        System.out.println("=====================================================");
        method = Test11.class.getMethod("test02",null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("actualTypeArgument = " + actualTypeArgument);
            }
        }
    }
}
