import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 회의의 수
		int[][] meetingTime = new int[N][2]; // 회의 시간 배열
		
		for(int i = 0; i < N; i++) {
		    meetingTime[i][0] = sc.nextInt(); // 시작시간
		    meetingTime[i][1] = sc.nextInt(); // 끝나는 시간
		}
		
		Arrays.sort(meetingTime, new Comparator<int []>() {
		    public int compare(int[] o1, int[] o2) {
		        if(o1[1] == o2[1]) {
		            // 끝나는 시간이 같다면
		            // 시작시간이 빠른 순으로 정렬
		            // o1 > o2 면 양수
		            // o1 = o2 면 0
		            // o1 < o2 면 음수
		            return o1[0] - o2[0];
		        }
		        
		        return o1[1] - o2[1];
		    }
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(prev_end_time <= meetingTime[i][0]) {
				prev_end_time = meetingTime[i][1];
				count++;
			}
		}
		
		System.out.println(count);
		
		
	}
}