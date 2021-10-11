package method;

public class Demo06 {
    public static void main(String[] args) {
        //阶乘
        System.out.println(Demo06.f(5));

    }

    public static int f(int n) {
       /* if (n == 1){
            return 1;
        }else  {
            return n*f(n-1);
        }*/

        return n == 1 ? n : n * f(n - 1);
    }
}
