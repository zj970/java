package array;

public class ArrayDemo01 {
    //变量的类型 变量的名字 = 变量的值
    //数组的类型
    public static void main(String[] args) {
        int[] nums;//1.声明
        //int nums2[];//2.不建议

        nums = new int[10];//可以存放10个int类型的数字， 0-9的下标

        //或者一步到位 int[] nums = new int[10];

        //赋值 不赋值默认为0，跟数组的基类型默认值一直
        nums[0]=0;
        nums[1]=1;
        nums[2]=0;
        nums[3]=1;
        nums[4]=0;
        nums[5]=1;
        nums[6]=0;
        nums[7]=1;
        nums[8]=1;
        nums[9]=1;

        //循环打印 arrays.length 长度
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
