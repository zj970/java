import java.io.IOException;

//demo01 类
public class Demo01 {
    //main 方法
    public static void main(String[] args) {

        Demo01 demo01 = new Demo01();

        demo01.Max(4,5);
    }

    /*
    修饰符 返回值类型 方法名(){
        //方法体
        return 返回值;
    }
     */

    public String sayHello(){

        return  "hello";
    }

    public int Max(int a, int b){
        return  a>b ? a:b;//三元运算符
    }

    //数组越界 : Arrayindexouttofbounds

    public void readFile(String file) throws IOException{}

}
