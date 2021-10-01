package method;

import java.util.Scanner;

public class Demo01 {
    //main方法
    public static void main(String[] args) {
        //调用add方法
        int sum = add(1,2);
        System.out.println(sum);
        //调用test方法
        Demo01 demo01 = new Demo01();
        demo01.test();

    }

    //加法
    public static int add(int a, int b) {
        return a + b;
    }
    public void test(){
        Scanner scanner = new Scanner(System.in);
        //获取键盘输入的内容并输出
        String str = scanner.nextLine();
        System.out.println(str);
        scanner.close();
    }

}
