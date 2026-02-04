import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N]; // 수열 배열
		int[] ans = new int[N]; // 정답 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // 처음에는 항상 스택이 비어있으므로 최초 값을 push해 초기화
		
		for(int i=1; i<N; i++) {
			// 스택이 비어있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 클 경우
			while(!stack.isEmpty() && A[stack.peek()] < A[i]) {
				ans[stack.pop()] = A[i]; // 정답 배열에 오큰수를 현재 수열로 저장
			}
			stack.push(i);
		}
		
		while(!stack.empty()) {
			// 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌때까지
			ans[stack.pop()] = -1;
			// 스택에 쌓인 index의 정답 배열에 -1을 넣고
		}
				
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<N; i++) {
			bw.write(ans[i] + " "); // 출력
		}
		bw.write("\n");
		bw.flush();
	}
}