import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> days = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = (remain % speeds[i] == 0) 
                    ? (remain / speeds[i]) 
                    : (remain / speeds[i]) + 1;
            
            days.offer(day);
        }
        
        while (!days.isEmpty()) {
            int current = days.poll(); // 현재 배포 기준일
            int cnt = 1;
            
            // 뒤의 기능들이 current보다 빨리 끝나거나 같은 날 끝나면 같이 배포
            while (!days.isEmpty() && days.peek() <= current) {
                days.poll();
                cnt++;
            }
            
            answer.add(cnt);
        }
        
        return answer;
    }
}