//引用传递：对象：本质上还是值传递
//引用类型和值类型本质上是内存上的存储不同。

public class Demo05 {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person.name);
        Demo05.ChangeStr(person);
        System.out.println(person.name);

    }

    //Person 为一个类 ，是引用值类型
    public static void ChangeStr(Person person){
    //person是一个对象 指向的是堆里面的地址，在栈上存放其引用地址
        person.name = "Hello";
    }
}

//定义一个Person类，有一个属性 :name
class Person{
    String name;
}

