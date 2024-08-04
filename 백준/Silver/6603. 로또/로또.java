import java.util.*;

public class Main
{
    static int k = 0;
    static int[] num;
    static boolean[] check;
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
		    k = sc.nextInt(); // 개수
		    
		    if (k == 0) break; // k가 0이면 반복 종료
		    num = new int[k]; // 입력 숫자 담는 배열
		    check = new boolean[k]; // 숫자가 선택되었는지 체크하는 배열 (조합의 중복 방지)
		    
		    for (int i = 0; i < k; i++) num[i] = sc.nextInt(); // k개의 숫자 입력 받음
		    
		    dfs(0, 0);
		    System.out.println();
		}
		
	}
	
	public static void dfs(int dp, int start) {
	    
	    if (dp == 6) { // 6개의 숫자를 선택하는 경우
	        for (int i = 0; i < k; i++) {
	            if (check[i]) System.out.print(num[i] + " ");
	        }
	        
	        System.out.println();
	        return; // 탐색 종료
	    }
	    
	    for (int i = start; i < k; i++) { // 숫자를 선택하면서 깊이 우선 탐색
	        check[i] = true; // 숫자 선택
	        dfs(dp + 1, i + 1); // 재귀 호출, 다음 깊이 선택
	        check[i] = false; // 숫자 선택 해제 (다른 집합에서 사용할 수 있도록)
	    }
	    
	}
}