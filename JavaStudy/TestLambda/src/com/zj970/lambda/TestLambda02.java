package com.zj970.lambda;

public class TestLambda02 {
   static class Love1 implements ILove{

        @Override
        public void love(int a) {
            System.out.println("i love you  ---> " + a );
        }
    }

    public static void main(String[] args) {
        ILove love = new Love();
        love.love(1);
        ILove love1 = new Love1();
        love1.love(2);

        ILove love2 = new ILove() {
            @Override
            public void love(int a) {
                System.out.println("i love you  ---> " + a );
            }
        };
        love2.love(3);

        love = (int a )->{
            System.out.println("i love you  ---> " + a );
        };
        love.love(4);

        //1. 简化
        love = (a -> {
            System.out.println("i love you  ---> " + a );
        });
        love.love(5);

        //2. 简化
        love = a -> System.out.println("i love you  ---> " + a );
        love.love(6);


        //总结:
        /**
         * lambda表达式只有一行时才能简化成一行，如果有多行，使用代码块
         * 前提是接口为函数式接口，只有一个方法
         * 多个参数，也可以去掉参数类型，要去掉必须多去掉，必须加上()
         */

    }
}

interface ILove{
    void love(int a);
}

class Love implements ILove{

    @Override
    public void love(int a) {
        System.out.println("i love you  ---> " + a );
    }
}