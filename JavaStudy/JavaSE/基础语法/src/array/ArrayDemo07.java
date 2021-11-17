package array;

public class ArrayDemo07 {
    public static void main(String[] args) {
        int[] a = {1,5,4,8,2,8,8,6,9,10};

        a = Sort(a);

        ArrayDemo06.printArray(a);
    }

    //冒泡排序
    //1.比较数组中，两个相邻的元素，如果一个数比第二个大，交换他们的位置
    //2.每一轮比较，都会产生一个最大或者最小的数字
    //3.下一轮循环可以少一次排序
    //4.依次循环，直到结束！

    public static int[] Sort(int[] array){
        //int temp;

        boolean flag = false;//通过flag标识位减少没有意义的比较
        //外层循环，判断我们这个要走多少次
        for (int i = 0; i < array.length; i++) {
            //内层循环，比较相邻两个数，如果第一个数比第二个数大，交换位置
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]){
                    //temp = array[j];
                    //array[j] = array[j+1];
                    //array[j+1] = temp;

                    array[j] = array[j]^array[j+1];
                    array[j+1] = array[j+1]^array[j];
                    array[j] = array[j]^array[j+1];
                    flag = true;
                }
            }

            if (flag == false){
                break;
            }
        }

        return array;
    }

}
