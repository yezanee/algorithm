import java.util.*;

public class Main
{
    static int N, M; // 미로의 크기 
    static int[][] maze; // 미로
    static boolean[][] visited; // 방문 여부
    static int[] dx = {-1, 1, 0, 0}; // 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new int[N][M];
        visited = new boolean[N][M];
	    
        
        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        
        visited[0][0] = true; // 시작점
        bfs(0,0);
        System.out.println(maze[N-1][M-1]); // BFS 완료 후, 오른쪽 아래 셸의 값 출력 (= 최소 이동 횟수)
		
	}
	
	public static void bfs(int x, int y) {
	    Queue<int[]> q = new LinkedList<>();
	    q.add(new int[]{x, y}); // 시작
	    
	    while(!q.isEmpty()) {
	        int now[] = q.poll(); // 현재 셀 큐에서 제거
	        int nx = now[0]; // 제거된 좌표 저장
	        int ny = now[1]; // 제거된 좌표 저장
	        
	        for (int i = 0; i < 4; i++) {
	        // 각 방향에 대해 다음 셀의 좌표 계산
	            int nextX = nx + dx[i]; 
	            int nextY = ny + dy[i];
	            
	            if (nextX >= 0  && nextX < N && nextY >= 0 && nextY < M) {
                    if(maze[nextX][nextY]==1 && !visited[nextX][nextY]) {
                        q.add(new int[] {nextX, nextY}); // 큐에 추가
                        visited[nextX][nextY]=true; // 방문 표시
                        maze[nextX][nextY] = maze[nx][ny]+1;
                        // 다음 셀의 거리 값 업데이트
                        }
	            }
	        }
	    }
	}
	
}