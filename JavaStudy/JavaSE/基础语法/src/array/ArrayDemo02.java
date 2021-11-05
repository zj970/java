package array;

public class ArrayDemo02 {

    public static void main(String[] args) {
        //静态初始化
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(a[0]);

        //动态初始化 : 默认初始化
        int[] b = new int[10];
        b[0] = 1;
        System.out.println(b[0]);
        System.out.println(b[1]);
    }

}