package operator;

public class Demo07 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
         a+=b;
        System.out.println(a);

        //字符串连接符   + 只有String类型就可以拼接
        System.out.println(a + b);//50
        System.out.println("resoult:" + a + b);//结果为 ： 3020
        System.out.println(a + b + "resoult");//结果为 ： 50
        /*出现原因：运算的优先级，
        * 当String在左边的时候，首先是String + Int 转换成 String
        * 当String在右边的时候，首先是Int + Int 转换成 Int,再Int + String 转换成String
        * */
    }
}
