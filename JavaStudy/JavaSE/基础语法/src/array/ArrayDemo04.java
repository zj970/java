package array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5};

        //JDK1.5,没有下标
        for (int array: arrays
             ) {
            System.out.println(array);
        }

        System.out.println("==============增强性for循环=================");

        printArray(arrays);
        System.out.println("==========================数组反转===========================");
        printArray(reverse(arrays));

    }

    //打印数组元素
    public static  void printArray(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(i+"个数组元素值为："+arrays[i]);
        }
    }

    //反转数组
    public static int[] reverse(int[] arrays){
        int[] result = new int[arrays.length];

        //反转操作
        for (int i = arrays.length - 1, j = 0; i >= 0; i--) {
                result[j++] = arrays[i];
        }

        return result;
    }
}
