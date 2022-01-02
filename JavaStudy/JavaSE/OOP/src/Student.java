
//学生类
public class Student {
    //属性：字段
    String name;
    int age;

    //方法
    public void study(){
        System.out.println(this.name + "（学生）在学习");
    }

    //静态方法
    public static void Say(){
        System.out.println("学生说话了");
    }

    //非静态方法
    public void Write(){
        System.out.println("学生写字");
    }
    
}
