package struct;

public class ForDemo01 {
    public static void main(String[] args) {
        //初始化条件
        int a = 1;
        while (a <= 100){//条件判断
            System.out.println(a);//循环体
            a+=2;//迭代
        }

        for ( int i = 0,j = 0;i <=100 && j<=100;i++,j++){
            System.out.println(i + j);
        }
    }
}
/*
* 关于 for 循环有以下几点说明：
* 1.最先执行初始化步骤。可以声明一种类型，初始化可以一个或多个循环控制变量，也可以是空语句
* 2.然后，检测布尔表达式的值。如果为true,循环体被执行。如果为false，循环终止，开始执行循环体外的语句
* 3.每执行一次循环后，更新循环控制变量（迭代因子控制循环变量的增减）
* 4.再次检测布尔表达式，循环执行上面的过程。
*
* */
