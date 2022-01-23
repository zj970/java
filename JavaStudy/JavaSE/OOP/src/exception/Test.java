package exception;

public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        //假设要捕获多个异常，从小到大

        try {//try监控区域

            System.out.println(a / b);
        }catch (ArithmeticException e){//catch(想要捕获的异常类型)捕获异常Throwable 最高级
            //catch可以有多个,但是必须是小到大
            System.out.println("程序出现异常，变量b不能为0");
        }finally{
            //处理善后工作
            System.out.println("finally");
        }
        //finally 可以不要，假设IO，资源，关闭！（必要）

    }

    public void a(){b();}
    public void b(){a();}
}
