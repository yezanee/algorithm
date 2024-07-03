import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 게임 판의 크기
        int[][] gamepan = new int[n][n]; // 게임 판
        long[][] dp = new long[n][n]; // 각 칸까지의 경로 수를 저장할 DP 배열

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gamepan[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1; // 시작 지점 초기화

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) continue; // 목표 지점은 더 이상 진행하지 않음
                int jump = gamepan[i][j];
                if (jump == 0) continue; // 0인 경우는 더 이상 진행할 수 없음

                if (i + jump < n) dp[i + jump][j] += dp[i][j]; // 아래로 점프
                if (j + jump < n) dp[i][j + jump] += dp[i][j]; // 오른쪽으로 점프
            }
        }

        System.out.println(dp[n - 1][n - 1]); // 목표 지점까지의 경로 수 출력
    }
}