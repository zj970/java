package method;

public class Demo04 {
    public static void main(String[] args) {
        Demo04 demo04 = new Demo04();
        demo04.method(1,2,3,4);
    }

    public void method(){}
    public void method(int i){}
    public void method(int i, int j){}
    public void method(double i, int j){}
    public void method(double i, double j){}

    //不定参数 一个方法只能指定一个参数
    public void method(double...i){}

}
