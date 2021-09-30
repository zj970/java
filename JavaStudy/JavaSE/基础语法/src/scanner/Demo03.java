package scanner;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("接收:");

        String str = scanner.nextLine();
        System.out.println("输出的内容为:" + str);

        //关闭IO
        scanner.close();
    }
}
