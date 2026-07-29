import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        int changeCnt = 0;
        
        queue.add(begin);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int k=0; k<size; k++) {
                String cur = queue.poll();
                
                if (cur.equals(target)) {
                    return changeCnt;
                }
                
                for(int i=0; i<words.length; i++) {
                    if (visited[i]) continue;
                    
                     String word = words[i];
                    
                    int cnt = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) == cur.charAt(j)) {
                            cnt++;
                        }
                    }
                    
                    if (cnt == word.length() - 1) {
                        visited[i] = true;
                        queue.add(word);
                    }
                }
            }
            changeCnt++;
        }
        return 0;
    }
}