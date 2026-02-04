import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if (first_abs == second_abs)
				return o1 > o2 ? 1 : -1; // 절댓값이 같으면 음수 우선 정렬하기
			else
				return first_abs - second_abs;
		});
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (pq.isEmpty()) System.out.println("0");
				else System.out.println(pq.poll());
			} else {
				pq.add(num);
			}
		}
	}
}
		