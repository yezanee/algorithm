import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] sum = new long[N+1];
		long[] indexCnt = new long[M];
		long result = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + Long.parseLong(st.nextToken());
		}
		
		for(int i=1; i<=N; i++) {
			long remainder = sum[i] % M;
			
			// 0 ~ i까지의 구간 합 자체가 0일 때 정답에 더하기
			if(remainder == 0) result++;
			
			// 나머지가 같은 인덱스의 개수 카운팅하기
			indexCnt[(int)remainder]++;
		}
		
		for(int i = 0; i < M; i++) {
			if(indexCnt[i] > 1) {
				// 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
				result = result + (indexCnt[i] * (indexCnt[i]-1) / 2);
			}
		}
		System.out.println(result);
	}
}		