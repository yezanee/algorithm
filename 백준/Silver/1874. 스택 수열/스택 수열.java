import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		boolean result = true;
		
		for(int i=0; i<n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n; i++) {
			if(numArr[i] >= num) { // 현재 수열 값 >= 오름차순 자연수
				while (numArr[i] >= num) { // 값이 같아질 때까지 push
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop(); // 값이 같아질 때
				sb.append("-\n");
			}
			else { // 현재 수열 값 < 오름차순 자연수
				int j = stack.pop(); // pop을 수행해 수열 원소를 꺼냄
				// 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열 출력 X
				if (j > numArr[i]) {
					System.out.println("NO");
					result = false;
					break;
				}
				else {
					sb.append("-\n");
				}
			}
		}
		if (result) System.out.println(sb.toString());
	}
}					