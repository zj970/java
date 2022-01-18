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
/**
 * - Java 把异常当作对象来处理，并定义一个基类 java.lang.Throwable 作为所有异常的超类。
 *
 * - 在 java API 中一经定义了许多异常类，这些异常类分为两大类，错误Error和异常Exception.
 */