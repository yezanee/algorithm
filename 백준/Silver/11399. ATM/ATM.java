import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 사람 수
		int[] P = new int[N]; // 사람들이 돈을 인출하는데 걸리는 시간
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(P);
		
		
		int sum = P[0];
		int current = P[0];
		for(int i=1; i<N; i++) {
			current += P[i];
			sum += current;
		}
		
		System.out.println(sum);
	}
}