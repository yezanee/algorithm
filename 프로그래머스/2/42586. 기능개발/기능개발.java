import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 1. 각 기능의 작업 완료 날짜 계산
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int remainder = 100 - progresses[i];
            days[i] = (remainder + speeds[i] - 1) / speeds[i]; // 올림 계산
        }

        // 2. 배포를 그룹화
        List<Integer> result = new ArrayList<>();
        int currentMax = days[0];
        int count = 1;
        
        for (int i = 1; i < days.length; i++) {
            if (days[i] <= currentMax) {
                count++;
            } else {
                result.add(count); // 현재 그룹 크기 추가
                count = 1;         // 새 그룹 시작
                currentMax = days[i];
            }
        }
        result.add(count); // 마지막 그룹 크기 추가

        // 3. 결과 배열 생성
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        
        return finalResult;
    }
}
