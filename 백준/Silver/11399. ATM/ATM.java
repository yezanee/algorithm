import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람의 수
		int[] Pi = new int[N]; // 각 사람이 돈을 인출하는데 걸리는 시간
		int result = 0;
		
		for(int i = 0; i < N; i++) {
		    Pi[i] = sc.nextInt();
		}
		// 여기까지 입력 받고 초기화
		
		// 그리디 알고리즘
		Arrays.sort(Pi); // 시간 배열 오름차순 정렬
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
		    sum += Pi[i];
		    result += sum;
		}
		
		System.out.println(result); // 결과 출력
		
	}
}