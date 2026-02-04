import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			// 새로운 값이 들어올 때마다 현재 수보다 큰 값을 덱에서 제거
			while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
				mydeque.removeLast();
			}
			
			mydeque.addLast(new Node(now, i));
			
			// 범위에서 벗어난 값은 덱에서 제거
			if (mydeque.getFirst().index <= i - L) {
				mydeque.removeFirst();
			}
			
			sb.append(mydeque.getFirst().value).append(' ');
		}
		
		System.out.println(sb.toString());
	}
	
	static class Node {
		public int value;
		public int index;
		
		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}
}