import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 곡의 개수
        int S = sc.nextInt(); // 시작 볼륨
        int M = sc.nextInt(); // 볼륨의 최대
        int[] V = new int[N]; // 각각의 곡이 시작하기 전에 바꿀 수 있는 볼륨의 리스트
        
        for (int i = 0; i < N; i++) {
            V[i] = sc.nextInt();
        }
        
        boolean[][] dp = new boolean[N+1][M+1];
        // dp[i][j]일 때, i번쨰 곡을 연주할 때 볼륨 j가 가능한지 나타내는 배열
        dp[0][S] = true;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) { // true
                    if (j + V[i] <= M) { // 범위 내
                        dp[i+1][j + V[i]] = true;
                    }
                    if (j - V[i] >= 0) { // 범위 내
                        dp[i+1][j - V[i]] = true;
                    }
                }
            }
        }
        
        int result = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[N][i]) { // 참이라면 (마지막 값 존재)
                result = i;
            }
        }
        
        System.out.println(result);
    }
}