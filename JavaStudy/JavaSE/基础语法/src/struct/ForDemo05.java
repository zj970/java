package struct;

public class ForDemo05 {
    public static void main(String[] args) {
        int[] numbers = {10,20,10,30,50};//定义了一个数组
        for (int x : numbers){//遍历数组的元素
            System.out.println(x);
        }
        System.out.println("=============================");
        for (int i = 0; i < 5; i++) {
            System.out.println(numbers[i]);
        }
    }
}
