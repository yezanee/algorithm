import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 동전 "종류"의 수, 동전의 개수는 무한.
		int K = sc.nextInt(); // 만드려고 하는 동전의 가치의 합
		int[] A = new int[N+1]; // 각각의 동전의 가치 배열 (오름차순)
		int idx = 1;
		int result = 0; // K원을 만드는데 필요한 동전 개수의 최솟값
		
		A[idx++] = 1;
		
		for(int i = 0; i < N; i++) {
		    A[i] = sc.nextInt();
		}
		
		for(int i = N - 1; i >= 0; i--) {
		    
		    // 현재 동전의 가치가 K보다 작거나 같으면
		    if(A[i] <= K) {
		        result += (K / A[i]);
		        K = K % A[i];
		    }
		}
		
		System.out.println(result);
		
	}
}