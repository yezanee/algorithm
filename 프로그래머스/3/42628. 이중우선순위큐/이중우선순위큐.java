import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String s : operations) {
            if(s.substring(0, 1).equals("I")) {
                min.add(Integer.parseInt(s.substring(2)));
                max.add(Integer.parseInt(s.substring(2))); 
            } else if(!min.isEmpty() && s.equals("D -1")) {
                max.remove(min.poll());
            } else if (!max.isEmpty() && s.equals("D 1")) {
                min.remove(max.poll());
            }
        }
        
        if(min.isEmpty() || max.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        
        return answer;
    }
}