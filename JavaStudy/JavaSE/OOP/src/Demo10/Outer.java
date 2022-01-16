package Demo10;

public class Outer {

    private int id = 10;
    public void out(){
        System.out.println("这是外部类的方法");
    }

    //局部内部类
    public void method(){
        class Inner{

        }
    }


    class Inner{
        public void in(){
            System.out.println("这是内部类的方法");
        }

        //获得外部类的私有属性
        public void getId(){
            System.out.println(id);
        }
    }
}
//一个java类中可以有多个class类，但是只有一个public class类
class A{
    public static void main(String[] args) {
        System.out.println("测试方法");
    }
}