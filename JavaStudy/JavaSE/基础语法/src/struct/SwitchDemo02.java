package struct;

public class SwitchDemo02 {
    public static void main(String[] args) {
        String name = "zj970";
        //JDK 7的新特性，表达式可以是字符串
        //字符的本质还是数字

        //反编译 java---class(字节码文件)----反编译(IDEA)


        switch (name){
            case "zj970":
                System.out.println(name);
                break;
            case "zj":
                System.out.println("zj");
                break;
            default:
                System.out.println("弄啥勒？");
        }
    }
}
