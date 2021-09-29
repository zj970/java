package operator;

public class Demo04 {
    public static void main(String[] args) {
        //++ -- 自增，自减 一元运算符 自左向右
        int a = 3;

        int b = a++;//先给b赋值，然后再自增加一
        int c = ++a;//先自增，然后再赋值给c
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        //幂运算 2^3 2*2*2 很多运算我们使用工具类
        System.out.println(Math.pow(2, 3));
    }
}
