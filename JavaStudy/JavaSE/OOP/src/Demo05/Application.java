package Demo05;

//学生 extends 人,子类继承父类，就会拥有父类的全部方法，但是只有public protected 两种修饰方式才能使用
public class Application {
    public static void main(String[] args) {
        Student student = new Student();
         student.Say();
         student.Test("测试");

//         B d = new A();
//         d.test();



        B b = new B();
        b.test();//B类

        //父类的引用指向了子类，所以这里调用的是A类的方法,这个行为叫做 向上造型
        A c = new B();
         c.test();//A类

        A a = new A();
        a.test();
    }
}

//在java中，所有的类都默认直接或者间接继承object
//静态的方法和非静态方法有很大的区别
//静态的方法：方法的调用只和左边，定义的数据有关
//非静态：方法重写和后面构造函数有关