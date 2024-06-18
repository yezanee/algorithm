import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] map; // 지도 정보
	static boolean[][] visited; // 특정 위치 방문 했는지
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static List<Integer> result; // 각 단지에 속한 아파트 수 저장
	static int cnt; // 현재 단지에 속한 아파트 수를 세기 위한 변수
	static int N; // 지도의 크기

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		result = new LinkedList<>(); 
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N]; 
		cnt = 1;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		// 각 줄의 문자열을 읽어서 각 문자를 숫자로 변환해 배열에 저장
		
		
		for(int x=0;x<N;x++) {
			for(int y=0;y<N;y++) {
				if(map[x][y]==1 && !visited[x][y]) { // 아파트가 있고 아직 방문하지 않은 지점 찾기
					dfs(x,y); // 지점 발견하면 메서드 호출
					result.add(cnt); // 탐색 끝나면 cnt 값을 결과 리스트에 추가
					cnt = 1; // cnt 초기화
				}
			}
		}
		
		Collections.sort(result); // 정렬
		
		bw.write(result.size()+"\n"); // 총 단지 수
		for(int r : result) bw.write(r+"\n"); // 각 단지에 속한 아파트 수
		bw.flush();
		bw.close();

	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true; // 위치 방문
		
		for(int i=0;i<4;i++) { // 상하좌우 네 방향으로 이동하며 이동할 수 있는 지 검사
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]==1) {
				// 이동할 수 있는 경우
				cnt++;
				dfs(nx,ny);
			}
		}
	}
}