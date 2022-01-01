
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

//学程序好？--对世界进行更好的建模--不能宅--面向对象--创造性。

/**
 * 1. 类与对象
 *      类是一个模板：抽象，对象是一个具体的实例
 * 2. 方法
 *      定义/调用
 * 3. 对应的引用
 *      引用类型： 基本类型(8)
 *      对象是通过引用来操作的：栈--堆
 * 4. 属性：字段Field成员变量
 *      默认初始化：
 *      数字：0 0.0
 *      char: u0000
 *      boolean: false
 *      引用:null
 *      修饰符 属性类型 属性名 = 属性值！
 * 5. 对象的创建和使用
 *  - 必须使用 new 关键字创造对象，构造器 Person men = new Person();
 *  - 对象的属性 men.name
 *  - 对象方法 men.sleep();
 *
 * 6. 类：
 *  静态的属性 属性
 */
