import java.util.*;

class Node {
    String word;
    int count;
    
    Node(String word, int count) {
        this.word = word;
        this.count = count;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            
            if(now.word.equals(target)) return now.count;
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && canChange(now.word, words[i])) {
                    queue.offer(new Node(words[i], now.count + 1));
                    visited[i] = true;
                }
            }
            
            
        }
        
        return 0;
    }
    
    public boolean canChange(String s1, String s2) {
        int cnt = 0;
        
        for(int i = 0; i < s1.length(); i++) {
            if(!(s1.charAt(i) == s2.charAt(i))) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}