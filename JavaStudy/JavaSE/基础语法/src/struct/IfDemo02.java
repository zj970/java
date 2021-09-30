package struct;

import java.util.Scanner;

//if双选择结构
public class IfDemo02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");

        int score = scanner.nextInt();

        if (score >= 60){
            System.out.println("成绩合格");
        }else{
            System.out.println("成绩不合格");
        }

        scanner.close();
    }
}
