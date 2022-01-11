package Demo07;

//static 不能被继承
public class Stundent {
    private static  int age;//静态变量 -- 类变量
    private double score;//非静态变量

    public static void main(String[] args) {
        Stundent stundent = new Stundent();
        System.out.println(stundent.score);

        System.out.println(Stundent.age);//直接用类调用，静态方法也是可以直接用类调用
    }
}
