package array;

public class ArrayDemo05{
    public static void main(String[] args) {
        //[3][2]
        /*
        * 1,2 array[0]
        * 2,3 array[1]
        * 3,4 array[2]
        * */
        int[][] array = {{1,2},{2,3},{3,4}};

        ArrayDemo04.printArray(array[0]);
        //ArrayDemo04.printArray(array[0][0]);
        System.out.println(array[0][0]);
        printArray(array);
    }

    public static void printArray(int[][] array){
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
