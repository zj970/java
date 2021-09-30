package struct;

public class DoWhileDemo02 {
    public static void main(String[] args) {
        int a = 0;
        while(a<0){
            System.out.println(a);
            a++;
        }
        System.out.println("=================================");
        int c = 0;
        do {
            System.out.println(c);
            c++;
        }while (c<0);
    }

}
