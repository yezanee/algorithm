import java.util.*;
import java.io.*;

public class Main {
	public static int N, result;
	public static long K, now, rest;
	public static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());
		A = new int[N];
		now = 0;
		rest = K;
		result = 0;
		
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		
		greedy(now, N-1, rest);
		
		System.out.println(result);
	}
	
	static void greedy(long now, int idx, long rest) {
		if (rest == 0) return;
		if (idx < 0) return;
		
		if (rest / A[idx] == 0) {
			while (idx >= 0 && rest / A[idx] == 0) {
				idx--;
			}
			greedy(now, idx, rest);
		} else {
			now += A[idx] * (rest / A[idx]);
			result += rest / A[idx];
			rest = rest - (A[idx] * (rest / A[idx]));
			idx--;
			greedy(now, idx, rest);
		}
	}
}