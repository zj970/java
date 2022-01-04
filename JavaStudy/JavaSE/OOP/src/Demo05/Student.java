package Demo05;
//学生 is 人 : 派生类，子类 私有的东西无法被继承
public class Student  extends Person{
    String name = "学生";
    public void Test(String name){
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);
    }

}
