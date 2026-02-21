import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		
		int data1=0;
		int data2=0;
		int sum=0;

		while(pq.size() != 1) {
			data1 = pq.remove();
			data2 = pq.remove();
			sum += data1+data2;
			pq.add(data1+data2);
		}
		
		System.out.println(sum);
	}
}