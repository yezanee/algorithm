import java.util.*;

class Solution {
    
    public int solution(int[][] maps) {
        int n = maps[0].length;
        int m = maps.length;
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        visited[0][0] = true;
        queue.offer(new int[]{0, 0, 1});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            if(x == n-1 && y == m-1) return dist;
            
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[ny][nx] && maps[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}