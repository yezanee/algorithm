import java.util.*;
import java.io.*;

public class Main {

    static int T; // 테스트 케이스 개수
    static int M; // 배추밭의 가로길이
    static int N; // 배추밭의 새로길이
    static int K; // 배추가 심어져 있는 위치의 개수
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] farm;
    static boolean[][] visited;
    static int result; // 현재 테스트 케이스에 대한 최소 배추흰지렁이 마리 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine());

        for(int r = 0; r < T; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
    
            farm = new int[N][M];
            visited = new boolean[N][M];
    
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }
            
            result = 0;
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if(farm[y][x] == 1 && !visited[y][x]) {
                        dfs(y, x);
                        result++;
                    }
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();

    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && farm[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }
}