import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // HashMap을 사용하여 각 선수의 이름과 등장 횟수를 저장
        HashMap<String, Integer> map = new HashMap<>();
        
        // completion 배열을 순회하여 각 이름의 등장 횟수를 증가
        for (String player : completion) {
            map.put(player, map.getOrDefault(player, 0) + 1);
            // 원래 등장했던 횟수 + 1
            // 존재하지 않을 경우 기본값 0
        }
        
        // participant 배열을 순회하며 등장 횟수를 감소
        for (String player : participant) {
            if (!map.containsKey(player) || map.get(player) == 0) {
                return player;  // 완주하지 못한 선수를 찾으면 반환
            }
            map.put(player, map.get(player) - 1);
            // 동명이인이 완주하지 못한 경우
        }
        
        return "";
    }
}