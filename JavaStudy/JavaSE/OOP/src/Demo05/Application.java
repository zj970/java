package Demo05;

//学生 extends 人,子类继承父类，就会拥有父类的全部方法，但是只有public protected 两种修饰方式才能使用
public class Application {
    public static void main(String[] args) {
        Student student = new Student();
         student.Say();
         student.Test("测试");
    }
}

//在java中，所有的类都默认直接或者间接继承object