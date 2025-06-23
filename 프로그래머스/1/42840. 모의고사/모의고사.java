import java.util.*;

class Solution {
    public int[] solution(int[] answers) { // 정답 배열이 매개변수로 들어옴
        
        int[] first = {1, 2, 3, 4, 5}; // 1번 수포자 답
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5}; // 2번 수포자 답
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3번 수포자 답
        
        int[] scores = new int[3]; // 수포자들 정답 개수
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) scores[0]++;
            if (answers[i] == second[i % second.length]) scores[1]++;
            if (answers[i] == third[i % third.length]) scores[2]++;
        }
        
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> result = new ArrayList<>(); // 정답자의 수가 정해져있지 않으므로 동적 크기 필요
        
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream() // List<Integer>를 Stream<Integer>로 변환
            .mapToInt(i -> i) // Integer → int (기본형 변환, 언박싱)
            .toArray(); // int[]로 반환
    }
}