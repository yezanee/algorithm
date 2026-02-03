import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] A = new long[N];
		
		for(int i=0; i<N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int cnt = 0;
		
		for(int i=0; i<N; i++) {
			int firstIdx = 0;
			int secondIdx = N-1;
			
			while(firstIdx < secondIdx) {
				long sum = A[firstIdx] + A[secondIdx];
				
				if (firstIdx == i) { firstIdx++; continue; }
				if (secondIdx == i) { secondIdx--; continue; }
				
				if (sum == A[i]) {
					cnt++;
					break;
				} else if (sum < A[i]) {
					firstIdx++;
				} else if (sum > A[i]) {
					secondIdx--;
				}
			}
		}
		
		System.out.println(cnt);
	}
}