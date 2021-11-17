package array;

import java.util.Arrays;

public class ArrayDemo06 {
    public static void main(String[] args) {
        int[] a = {1,2,3,5,4,88,41,5,7,15};
        System.out.println("打印数组元素"+a);//[I@1b6d3586-----------反射
        //打印数组元素
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        System.out.println("=========================分割线====================");
        System.out.println(Arrays.toString(a));
        System.out.println("=========================分割线====================");
        printArray(a);
    }

    public static void printArray(int[] a){
        for (int i = 0; i < a.length; i++) {
            if (i==0){
                System.out.print("[");
            }
            if (i == a.length-1){
                System.out.print(a[i] + "]");
            }
            else {
                System.out.print(a[i] + ", ");
            }

        }
    }
}
