import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 행렬의 개수
		int[][] matrixSize = new int[N][2]; // 행렬의 크기 배열
		
		for(int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    matrixSize[i][0] = Integer.parseInt(st.nextToken());
		    matrixSize[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][N]; // 행렬 곱하는데 필요한 곱셈 연산 횟수
		
		for (int len = 1; len < N; len++) {
		    for (int i = 0; i + len < N; i++) {
		        int j = i + len;
		        dp[i][j] = Long.MAX_VALUE;

		        for (int k = i; k < j; k++) {
		            dp[i][j] = Math.min(dp[i][j],
		                dp[i][k] + dp[k + 1][j] + matrixSize[i][0] * matrixSize[k][1] * matrixSize[j][1]);
		        }
		    }
		}

		System.out.println(dp[0][N - 1]);
	}
}


