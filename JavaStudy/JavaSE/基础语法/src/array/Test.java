package array;

//局部变量和全局变量
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.GetStr());
    }

    public char[] GetStr() {
        char[] arrays = new char[]{'h', 'e', 'l', 'l', 'o'};
        return arrays;
    }

}
