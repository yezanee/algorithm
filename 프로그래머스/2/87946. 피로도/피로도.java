class Solution {
    
    int maxCount;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        return dfs(k, visited, dungeons, 0);
    }
    
    public int dfs(int k, boolean[] visited, int[][] dungeons, int count) {
        
        maxCount = Math.max(maxCount, count);
        
        for(int i=0; i<dungeons.length; i++) {
            int min = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(k >= min && !visited[i]) {
                visited[i] = true;
                dfs(k - cost, visited, dungeons, count + 1);
                visited[i] = false;
            }
        }
        
        return maxCount;
    }
}