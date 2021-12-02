
public class Demo03 {

    public static void main(String[] args) {

        //实际参数和形式参数的基类型要对应。
        int add = Demo03.Add(1,2);
        System.out.println(add);
    }

    public static int Add(int a, int b){
        return a+b;
    }

}
