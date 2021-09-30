package scanner;

import javax.swing.plaf.synth.SynthUI;
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //从键盘接受数据
        int i = 0;
        float f = 0.0f;
        System.out.println("请输入整数:");
        if (scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数数据是 ： " + i);
        }else {
            System.out.println("没有输入整数");
        }

        System.out.println("请输入单精度浮点数:");
        if (scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("单精度浮点数为：" + f);
        }else {
            System.out.println("没有输入浮点数");
        }

        scanner.close();
    }
}
