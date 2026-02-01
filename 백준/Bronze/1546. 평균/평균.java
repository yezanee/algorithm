import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] score = new int[N];
		double sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(score);
		int max = score[N-1];
		
		for(int i=0; i<N; i++) {
			sum += (double)score[i]/max*100;
		}
		
		System.out.println(sum/N);
	}
}