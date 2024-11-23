import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] chess = { 1, 1, 2, 2, 2, 8 };
        int[] whiteChess = new int[6];
        int index = 0;

        for(int i = 0; i < 6; i++) {
            whiteChess[i] = sc.nextInt();
        }

        for(int i : chess) {
            if (whiteChess[index] != i) {
                System.out.print( i - whiteChess[index] + " ");
            } else {
                System.out.print("0 ");
            }

            index++;
        }

    }
}