import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int[][] dp = new int[10001][4]; // n을 1, 2, 3으로 나타냄 (모든 경우의 수)
        
        int T = Integer.parseInt(br.readLine());
        
        // 합이 3이하인 경우는 사전에 초기값 1을 넣어준다.
        // dp[n][k]는 n을 만들 때 마지막에 k를 사용하는 경우의 수를 의미합니다.
        dp[1][1] = 1; // 1을 1로 끝내는 경우의 수: 1 (1)
        dp[2][1] = 1; // 2를 1 + 1로 끝내는 경우의 수: 1 (1 + 1)
        dp[2][2] = 1; // 2를 2로 끝내는 경우의 수: 1 (2)
        dp[3][1] = 1; // 3을 1 + 1 + 1로 끝내는 경우의 수: 1 (1 + 1 + 1)
        dp[3][2] = 1; // 3을 1 + 2로 끝내는 경우의 수: 1 (1 + 2)
        dp[3][3] = 1; // 3을 3으로 끝내는 경우의 수: 1 (3)
        
        // 주어지는 정수 n의 최댓값인 10000까지 경우의 수를 미리 저장해두고
        // 주어지는 n값에 대한 dp 를 출력한다.
        for (int j=4; j<=10000; j++) {
            dp[j][1] = dp[j-1][1];
            dp[j][2] = dp[j-2][1] + dp[j-2][2];
            dp[j][3] = dp[j-3][1] + dp[j-3][2] + dp[j-3][3];
        }
        
        for (int i=0; i<T; i++) {
            
            int n = Integer.parseInt(br.readLine());
            
            sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}