package Demo10;
//内部类
public class Application {
    public static void main(String[] args) {
        Outer outer = new Outer();//外部类实例
        //内部类 -- 通过外部类来实例化

       Outer.Inner inner = outer.new Inner();
       inner.in();
       inner.getId();//静态内部类无法获得外部类属性

    }
}
