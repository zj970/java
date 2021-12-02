package base;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Demo08 {
    //类变量 static
    static double salary = 2500;


    //属性：变量

    //实例变量：从属于对象,不初始化就默认值，所有值类型一般是 0
    //布尔值：默认值是false

    String name;
    char age;

    //main方法
    public static void main(String[] args) {
        //局部变量：必须声明和初始化值
        int i = 0;
        System.out.println(i);

        //变量类型  变量名字 = new Demo08;
        Demo08 demo08 = new Demo08();
        System.out.println(demo08);
        System.out.println(demo08.age);
        System.out.println(demo08.name);
    }


    //其他方法
    public void add(){

    }
}
