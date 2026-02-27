import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int k = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i : scoville) {
            pq.add(i);
        }
        
        while(pq.size() >= 2 && pq.peek() < K) {
            k = pq.poll() + (pq.poll() * 2);
            pq.add(k);
            answer++;
        }
        
        if(pq.peek() < K) return -1;
        
        return answer;
    }
}