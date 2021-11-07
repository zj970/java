package array;

public class ArrayDemo03 {
    public static void main(String[] args){
        int[] arrays = {1,2,3,4,5};
        //TODO:打印所有的数组元素
        System.out.println(test(5));

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }

    }

    public static int test(int n){
        return n > 1 ? n*test(n-1): n;
    }

}
