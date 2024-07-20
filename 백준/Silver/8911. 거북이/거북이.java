import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
	
		for(int i = 0; i < T; i++) {
		    int minX = 0, minY = 0, maxX = 0, maxY = 0; // 로봇의 이동범위 계산 위하여
		    int dir = 0; // direction, 즉 방향 변수. 0은 북쪽, 1은 동쪽, 2는 남쪽, 3은 서쪽을 의미
		    int nowX = 0, nowY = 0; // 현재 위치 (초기위치 (0,0))
		    
		    String command = br.readLine();
		    
		    for (int j = 0; j < command.length(); j++) {
		        char c = command.charAt(j); // 명령 하나 저장
		        
		        if (c == 'F') { // 한 눈금 앞으로
		            nowX = nowX + dx[dir];
		            nowY = nowY + dy[dir];
		        } else if (c == 'B') { // 한 눈금 뒤로
		            nowX = nowX - dx[dir];
		            nowY = nowY - dy[dir];
		        } else if (c == 'L') { // 왼쪽으로 90도
		            if (dir == 0) dir = 3; // 범위 '0 ~ 3' 안에 들어오도록
		            else dir--; // 현재 방향에서 반시계 방향
		        } else if (c == 'R') { // 오른쪽으로 90도
		            if (dir == 3) dir = 0; // 범위 '0 ~ 3' 안에 들어오도록
		            else dir++; // 현재 방향에서 시계 방향
		        }
		        
		        /* 로봇이 이동하는 전체 범위 추적 */
		        minX = Math.min(minX, nowX);
            minY = Math.min(minY, nowY);
            maxX = Math.max(maxX, nowX);
            maxY = Math.max(maxY, nowY);
		    }
		    sb.append( (Math.abs(minX)+Math.abs(maxX)) * (Math.abs(minY)+Math.abs(maxY)) + "\n");
				// 너비 계산
		}
		System.out.println(sb.toString());
	}
}