//引用传递：对象：本质上还是值传递
//引用类型和值类型本质上是内存上的存储不同。

public class Demo05 {
    public static void main(String[] args) {
        String name = "周健";
        Person person = new Person(name);
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

    //显示的自定义构造器---->实例化初始值
    //实例化初始值
    //1.使用关键字 new ，必须要有构造器
    //有参构造----》本质上调用构造器
    //2.一旦定义了有参构造，，无参构造必须显示定义----》即不显示默认没有无参构造函数
    public  Person(String name){this.name = name; }

    //快捷键 ALT + insert 生成构造函数，

}
//一个类即使什么都不写，它也会有一个默认构造方法

/*
public static void main(String[] args){

    //new 实例化一个对象
    Person person = new Person("zf",32);
    System.out.println(person.name);
    }

 */

/*
构造器：
    1.和类名相同
    2.没有返回值
    作用：
    1.new 本质上是调用构造方法
    2.初始化对象的值
    注意点：
    1.在定义有参构造之后，如果想使用无参构造，必须显示定义一个无参构造
    2.快捷键
    ALT + insert 有参
 */
