import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 퇴사하기 까지 남은 시간
		int[][] calender = new int[N+1][2]; // 상담 일정표 (1-base index 사용)
		int[] dp = new int[N+1]; // 각 날짜별 최대 수익을 저장
		
		// 상담 일정 입력 받기
		for(int i = 1; i <= N; i++) {
		    calender[i][0] = sc.nextInt(); // 상담을 완료하는데 걸리는 기간
		    calender[i][1] = sc.nextInt(); // 받을 수 있는 금액
		}
		
		// 각 날짜별 최대 수익 계산
		for(int i = 1; i <= N; i++) {
		    // 현재 날짜의 상담을 하지 않는 경우, 이전 날짜까지의 최대 수익을 그대로 가져옴
		    dp[i] = Math.max(dp[i], dp[i-1]);
		    
		    // 현재 날짜의 상담을 하는 경우
		    int endDate = i + calender[i][0] - 1; // 상담이 끝나는 날짜 계산
		    if(endDate <= N) { // 상담이 퇴사일 전이나 당일에 끝나는 경우
		        // 상담을 했을 때의 최대 수익과 현재까지의 최대 수익 비교 후 갱신
		        dp[endDate] = Math.max(dp[endDate], dp[i-1] + calender[i][1]);
	    	}
	    }
	    
	    // 마지막 날까지의 최대 수익 계산
	    int maxProfit = 0; // 최대 수익 저장 변수 초기화
	    for (int i = 1; i <= N; i++) { // 모든 날짜를 순회하며 최대 수익 계산
	        maxProfit = Math.max(maxProfit, dp[i]);
	    }
	    
	    System.out.println(maxProfit); // 최대 수익 출력
    }
}