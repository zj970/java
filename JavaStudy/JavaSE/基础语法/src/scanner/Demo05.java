package scanner;

import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //我i们可以输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果

        Scanner scanner = new Scanner(System.in);
        //和
        double sum = 0f;
        //计算输入了多少个数字
        int m = 0;
        //通过while循环判断，并求和统计
        while (scanner.hasNextFloat()) {
            m++;
            sum += scanner.nextFloat();
            System.out.println("你输入了第" + m + "个数据，当前结果为: " + sum);
        }

        System.out.println("数据总个数为：" + m);
        System.out.println("输入数据的结果是：" + sum);
        System.out.println(m + "个数的平均值为：" + sum / m);


        scanner.close();
    }
}
