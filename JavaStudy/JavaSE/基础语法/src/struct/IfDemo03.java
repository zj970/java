package struct;

import java.util.Scanner;

//if多选择语句
public class IfDemo03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入成绩：");

        int score = scanner.nextInt();
        /*
        * if 语句至少有一个 else 语句，else 语句在所有的 esle if 语句之后。
        * if 语句可以有若干个 else if 语句，它们必须在 else 语句之前。
        * 一旦其中一个 else if 语句检测为 true ，其他的 else if 语句 以及 else 语句都将跳过执行
        * */
        if (score >= 60 && score<70){
            System.out.println("成绩合格");
        }else if(score >=70&&score<80) {
            System.out.println("成绩中等");
        }else if(score >=80&&score<90) {
            System.out.println("成绩良好");
        }else if(score >=90&&score<=100) {
            System.out.println("成绩优秀");
        }else if(score >=0&&score<60) {
            System.out.println("成绩不合格");

        }else{
            System.out.println("成绩不合法");
        }

        scanner.close();
    }
}
