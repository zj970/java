
//值传递
public class Demo04 {
    public static void main(String[] args) {
        int a = 1;
        System.out.println(a);
        Demo04.SetValue(a);
        System.out.println(a);

    }
    //改变值的方法
    //返回值为空
    public static void SetValue(int a) {
        a = 10;
    }
}



