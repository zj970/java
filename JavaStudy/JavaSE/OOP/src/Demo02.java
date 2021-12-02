

public class Demo02 {

    public static void main(String[] args) {
        //静态方法 static -----？和类一起加载的
        Student.Say();//静态
        Student student = new Student();
        student.Write();//非静态

    }


    //非静态方法 ---- 》实例化出new 一个对象

}

