import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 보도블럭 개수
		char[] arr = br.readLine().toCharArray(); // 보도블럭
		int[] dp = new int[N]; // 에너지
		
		Arrays.fill(dp, Integer.MAX_VALUE); // 모든 값 아직 도달할 수 없음을 의미
		dp[0] = 0; // 시작점 -> 시작점 에너지 없음
		
		for (int i = 1; i < dp.length; i++) { // 현재 위치
			for (int j = 0; j < i; j++) { // 이전 위치
				if(arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
				// 현재 위치 'O'이고 이전 위치가 'B'이며 이전위치가 도달할 수 있는 위치일 때
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
					// 최소 에너지 갱신
				}
				else if(arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
				// 현재 위치 'J'이고 이전 위치가 'O'이며 이전 위치가 도달할 수 있는 위치일 때
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
					// 최소 에너지 갱신
				}
				else if(arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
				// 현재 위치 'B'이고 이전 위치가 'J'이며 이전 위치가 도달할 수 있는 위치일 때
					dp[i] = Math.min(dp[i], dp[j] + (i-j)*(i-j));
					// 최소 에너지 갱신
				}
				
			}
		}
		System.out.println((dp[N-1]==Integer.MAX_VALUE)?-1:dp[N-1]);
		// 링크의 위치가 도달가능한 위치이면 에너지 값 출력
		// 도달할 수 없는 위치이면 -1 출력
	}

}