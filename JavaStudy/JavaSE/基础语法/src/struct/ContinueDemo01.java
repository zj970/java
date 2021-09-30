package struct;

public class ContinueDemo01 {
    public static void main(String[] args) {
        int i = 0;
        while ( i < 100){
            i++;
            if (i%10==0){
                System.out.println();
                continue;
            }
            System.out.print(i+"\t");
        }
    }
}
