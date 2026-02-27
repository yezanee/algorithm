import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] complement = new int[progresses.length];
        List<Integer> list = new ArrayList<>();
        int cnt = 1;
        int max = 0;
        
        for(int i=0; i<complement.length; i++) {
            complement[i] = (100 - progresses[i]) % speeds[i] != 0 ?
                (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];
        }
        
        max = complement[0];
                
        for(int i=1; i<complement.length; i++) {
            if(max >= complement[i]) cnt++;
            else { list.add(cnt); cnt=1; max = complement[i]; }
        }
        list.add(cnt); // 중요
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}