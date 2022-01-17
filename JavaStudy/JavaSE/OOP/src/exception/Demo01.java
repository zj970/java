package exception;

public class Demo01 {
    public static void main(String[] args) {

        //new  Demo01().a();StackOverflowError堆栈溢出
        System.out.println(11 / 0);//.ArithmeticException: / by zero 除数不能为0
    }
    public void a(){
        b();
    }
    public void b(){
        a();
    }
}
