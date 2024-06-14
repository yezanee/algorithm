import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static long TreeSearch(long N, long M, long[] H) {
        
        long answer = 0;
        long low = 0;
		long high = H[H.length-1];
		
		while (low <= high) {
		    
		    long takeLength = 0;
		    long mid = (low + high) / 2; // 상근이가 지정한 높이
		    
		    for(int i = 0; i < N; i++) {
		        if (H[i] > mid) takeLength += H[i] - mid;
		    }
		    
		    if (takeLength < M) { high = mid - 1; }
		    else { answer = mid; low = mid + 1; }
	    }
	    
	    return answer;
    }
    
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long N = in.nextInt(); // 총 나무의 수
		long M = in.nextInt(); // 적어도 가져가야 하는 나무의 길이
		long[] H = new long[(int)N]; // 나무의 높이 배열
		
		for (int i = 0; i < N; i++) {
		    H[i] = in.nextLong(); // 나무 높이 입력 받기
		}
		
		Arrays.sort(H); // 높이 배열 정렬
		
		System.out.println(TreeSearch(N, M, H));
        
    }
}