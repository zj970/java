package array;

import javax.swing.*;

public class ArrayDemo03 {
    public static void main(String[] args){
        int[] arrays = {1,2,3,4,5};
        System.out.println(test(5));
        //TODO:打印所有的数组元素
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }
        int sum = 0;
        System.out.println("===============================");
        //计算所有元素的和
        for (int i = 0; i < arrays.length; i++) {
            sum += arrays[i];
        }
        System.out.println("和为"+ sum);
        System.out.println("================");
        //查找最大元素
        int max = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] > max){
                max = arrays[i];
            }
        }
        System.out.println("最大的元素"+max);
    }

    public static int test(int n){
        return n > 1 ? n*test(n-1): n;
    }

}
