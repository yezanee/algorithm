import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int N = sc.nextInt();
        int[][] moneyAndCnt = new int[N][2];
        int result = 0;

        for(int i = 0; i < N; i++) {

            moneyAndCnt[i][0] = sc.nextInt(); // 물건의 가격
            moneyAndCnt[i][1] = sc.nextInt(); // 물건의 개수
            
            result += moneyAndCnt[i][0] * moneyAndCnt[i][1];
        }
        
        if (result == X) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}