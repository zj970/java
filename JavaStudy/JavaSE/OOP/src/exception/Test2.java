package exception;

public class Test2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        //捕获异常快捷键 Ctrl + alt +  T

        try {
            //主动抛出异常 throw throws
            if (b==0){
                throw new ArithmeticException();
            }
            System.out.println(a / b);
        }catch (Exception e){
            System.exit(0);//退出
            e.printStackTrace();//打印错误的栈信息
        }finally{

        }
        new Test2().s(1,0);

    }

    //假设在这方法中，处理不了这个异常，方法上抛出异常
    public void s(int a,int b){
        if (b==0){
            throw new ArithmeticException();//主动抛出异常,一般在方法中使用
        }
        System.out.println(a / b);
    }
}
