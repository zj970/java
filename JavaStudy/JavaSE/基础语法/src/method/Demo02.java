package method;

public class Demo02 {
    public static void main(String[] args) {

        System.out.println(max(5, 4));
    }

    //比大小
    public static int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
    //return 0;//终止方法
}
