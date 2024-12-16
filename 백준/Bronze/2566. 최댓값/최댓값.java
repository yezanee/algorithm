import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[9][9];
        Scanner sc = new Scanner(System.in);
        int row = 0, col = 0;
        int max = 0;

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                array[i][j] = sc.nextInt();
                if(max <= array[i][j]) {
                    col = i+1;
                    row = j+1;
                    max = array[i][j];
                }
            }
        }

        System.out.println(max);
        System.out.println(col + " " + row);

    }
}