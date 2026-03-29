import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int[] deployTime = new int[progresses.length];
        for(int i=0; i<deployTime.length; i++) {
            // 걸리는 시간 계산
            int quotient = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];
            
            if(remain > 0) deployTime[i] = quotient + 1;
            else deployTime[i] = quotient;
        }
                
        // 한꺼번에 배포하는 작업 단위 별로 묶기
        int cnt = 1;
        int currentMax = deployTime[0];
        
        for(int i=1; i<deployTime.length; i++) {
            if (currentMax >= deployTime[i]) {
                cnt++;
            } else {
                currentMax = deployTime[i];
                answer.add(cnt);
                cnt = 1;
            }
        }
        
        answer.add(cnt);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}