package com.zj970.lambda;

/**
 * 推导lambda表达式
 */
public class TestLambda01 {

    //3. 静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I don't like Lambda.");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();
        ILike like2 = new Like2();
        like2.lambda();

        //4. 局部内部类
        class Like1 implements ILike{

            @Override
            public void lambda() {
                System.out.println("I like lambda1.");
            }
        }

        //5. 匿名内部类，没有类的名称，必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like lambda4");
            }
        };

        like.lambda();

        //6. 用Lambda简化
        like = ()->{
            System.out.println("I like lambda5");
        };
        like.lambda();

    }
}

//1. 定义一个函数式接口
interface ILike{
    void lambda();
}

//2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }
}
