//类 private : 私有


/**
 * 1.提高程序的安全性，保护数据
 * 2.隐藏代码的实现细节
 * 3.统一接口
 * 4.系统可维护增加
 */
public class Demo06 {

    //属性私有
    private String name;//名字
    private int id;//学号
    private char sex;//性别
    private int age;

    //提供一些可以操作这个属性的方法
    //提供一些 public 的 get/set 方法

    //get 获得这个数据
    public String getName(){
        return this.name;
    }
    //set 设置这个数据
    public void setName(String name){
        this.name = name;
    }

    //alt + insert 自动生成属性方法


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age > 0 && age < 120){
            this.age = age;
        }
        else {
            System.out.println("输入年龄不合法");
            this.age = 0;
        }
    }
}
