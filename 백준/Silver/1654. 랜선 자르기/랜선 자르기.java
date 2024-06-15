import java.util.Scanner;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int K = in.nextInt(); // 오영식이 이미 가지고 있는 랜선의 개수
        int N = in.nextInt(); // 필요한 랜선의 개수
        long[] K_lengthArr = new long[K];
        
        // N개의 랜선이 필요함.
        // K개의 랜선 이미 가지고 있음. (길이 제각각, 같은 길이로 잘라야 됨.)
        
        for(int i = 0; i < K; i++) {
            K_lengthArr[i] = in.nextLong();
        }
        
        Arrays.sort(K_lengthArr);
        
        long min = 0;
        long max = K_lengthArr[K_lengthArr.length - 1] + 1;
        
        while (min < max) {
	        long mid = (max + min) / 2;
	        long count = 0;
	        
	        for (int i = 0; i < K_lengthArr.length; i++) {
		        count += (K_lengthArr[i] / mid);
		      }
		      
		      if (count < N) { // 개수 더 필요 (더 작게 쪼개기)
			      max = mid; // max 크기 줄이기
		      } else { // 개수 너무 많음
			      min = mid + 1; // min 크기 늘리기
			    }
			  } 
			  
			  System.out.println(min - 1);
				
     
    }
}