import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int[] arr = new int[N+1];
		int sum = 1;
		int startIdx = 1;
		int endIdx = 1;
		
		while(endIdx != N) {
			
			if(sum > N) {
				sum = sum - startIdx;
				startIdx++;
			} else if (sum < N) {
				endIdx++;
				sum = sum + endIdx;
			} else {
				endIdx++;
				sum = sum + endIdx;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}		