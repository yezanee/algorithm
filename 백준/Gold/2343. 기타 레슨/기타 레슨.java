import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] len = new int[N];
		
		st = new StringTokenizer(br.readLine());
		int start = 0;
		int end = 0;
		for(int i=0; i<N; i++) {
			len[i] = Integer.parseInt(st.nextToken());
			if (start < len[i]) start = len[i];
			end += len[i];
		}
		
		while(start <= end) {
			int pivot = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i=0; i<N; i++) {
				if (sum+len[i] > pivot) {
					count++;
					sum = 0;
				}
				sum = sum + len[i];
			}
			if (sum != 0) count++;
			if (count > M) start = pivot +1;
			else end = pivot -1;
		}
		System.out.println(start);
	}
}