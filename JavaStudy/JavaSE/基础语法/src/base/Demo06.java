package base;

public class Demo06 {
    public static void main(String[] args) {
        //操作比较大的数的时候，注意溢出问题
        //JDK新特性，数字之间可以用下划线分割
        int money = 10_0000_0000;
        int years = 20;
        int total = money * years;
        System.out.println(money);
        System.out.println(total);
        long l_total = money * years;//结果也是溢出，因为先计算结果为int型，后赋值。-1474836480
        System.out.println(l_total);
        long total1 =(long) money * years;//进行强转
        System.out.println(total1);
    }
}
