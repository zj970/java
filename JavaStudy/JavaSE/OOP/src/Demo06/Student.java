package Demo06;

public class Student extends Person{
    @Override
    public void run() {
        //super.run();
        System.out.println("Student -> run()");
    }

    public void speak(){
        System.out.println("Student - > speak()");
    }
}
