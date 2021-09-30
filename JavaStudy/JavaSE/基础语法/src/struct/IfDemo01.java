package struct;


import java.util.Scanner;
//if单选择结构
public class IfDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        String str = scanner.nextLine();

        //equals:判断字符串是否相等
        if (str.equals("hello")){
            System.out.println(str);
        }else{
            System.out.println("end");
        }

        scanner.close();
    }
}
