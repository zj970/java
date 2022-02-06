package exception.Demo02;

public class Test3 {
  

    static void test(int a) throws MyException{
        System.out.println("传递的参数为" + a);
        if (a>10){
            throw new MyException(a);//抛出throws MyException
        }
        System.out.println(a+" -- ok");
    }

    public static void main(String[] args) {
        try {
            test(11);
        }catch (MyException e){
            System.out.println("MyException=>" + e);
        }
    }
}
