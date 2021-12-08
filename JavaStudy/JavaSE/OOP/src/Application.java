
//一个项目应该值存在一个 main 方法
public class Application {
    public static void main(String[] args) {

        //类是抽象的实例化
        //类实例化后会返回一个自己的对象！
        //Student 对象就是一个Student类的具体实例!
        Student student = new Student();
        Student xiaoming = new Student();
        student.name = "小明";
        System.out.println(student.age);
        xiaoming.study();
        student.study();

        Pet dog = new Pet();
        dog.name = "旺财";
        dog.age = 3;
        dog .shout();

    }
}

//学程序好？ 对世界进行更好的建模!-----不能宅-----
