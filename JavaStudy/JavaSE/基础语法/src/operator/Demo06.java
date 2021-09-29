package operator;

public class Demo06 {
    public static void main(String[] args) {
        /*
        * A = 0011 1100
        * B = 0000 1101
        *
        * A&B = 0000 1100 两者为1才是1
        * A|B = 0011 1101 其中有1便为1
        * A^B = 0011 0001 相同为0异为1
        * ~B = 1111 0010 按位取反 10进制结果为负数加一
        *
        *
        * 2*8 = 16 怎么运算最快？
        * <<左移  >>右移
        * 位运算效率极高
        * */

        System.out.println(2 << 3);
        System.out.println(~5);

    }
}
