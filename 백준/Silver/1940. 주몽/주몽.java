import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 재료의 개수
		long M = Integer.parseInt(br.readLine()); // 갑옷을 만드는데 필요한 수
		
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int firstIdx = 0;
		int secondIdx = N-1;
		int cnt = 0;
		
		while(firstIdx < secondIdx) {
			long sum = (long) nums[firstIdx] + nums[secondIdx];
			if (sum == M) {
				cnt++;
				firstIdx++;
				secondIdx--;
			} else if (sum < M) {
				firstIdx++;
			} else {
				secondIdx--;
			}
		}
		
		System.out.println(cnt);
	}
}
		