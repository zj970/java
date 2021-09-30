package struct;

public class ForDemo03 {
    //练习2： 用 while 或for 循环输出1-1000之间能被5整除的数，并且每行输出3个
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i <= 1000; i++) {
            if (i % 5 == 0) {
                j++;
                System.out.print(i + "\t");
                if (j == 3) {
                    System.out.println();
                    j = 0;
                }
            }
        }
    }

    //print 输出不换行
    //println 输出换行
}
