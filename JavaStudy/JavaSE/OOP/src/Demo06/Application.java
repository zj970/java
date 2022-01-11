package Demo06;

public class Application {
    public static void main(String[] args) {
        //一个对象的实际类型是确定的

        //可以指向的引用类型就不确定
        Student s1 = new Student();
        Person s2 = new Student();
        Object s3 = new Student();

        //Student s4 = new Person();只能父类引用指向子类类型
        s1.eat();
        s2.eat();

        s1.run();//子类重写了父类的方法，就执行子类的方法
        s2.run();

        //对象能执行那些方法，主要看左边的类型，和右边类型关系不大
        s1.speak();
        ((Student) s2).speak();//直接调用引用类没有的方法（类型转换）

        //父类的类型 可以指向子类，但不能调用子类独有的方法
        //庖丁解牛的学习精神
        //后天开始新生活


        //Object > Person > Student

        //1. 可以把Object,Person,Student 理解成三个包含关系的圆
        //2. new 一个Student对象，那么这个对象的实际位置就在Student里面
        //3. 用instanceof进行比较，就是判断对象的实际位置是不是在这个圆里
        Object object = new Student();


        System.out.println(object instanceof Student);//true
        System.out.println(object instanceof Person);//true
        System.out.println(object instanceof Teacher);//false
        System.out.println(object instanceof String);//false

        //类型转换 ： 父，子
        Person student1 = new Student();//高——>底
        ((Student) student1).run();

        //子》父 可能会丢失一些子类的方法
        Student su = new Student();
        Person p = su;
        p.run();


    }
}
