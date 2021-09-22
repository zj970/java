package operator;

public class Demo02 {
    public static void main(String[] args) {
        long a = 1234564987141654L;
        int b = 123;
        short c = 10;
        byte d = 8;

        //不同类型的混合运算无论是赋值还是运算都是向最高位转
        System.out.println(a + b + c + d);//:Long
        System.out.println(b + c + d);//:Int
        System.out.println(c + d);//Int
    }
}
