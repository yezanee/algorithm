import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> comb = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            comb.put(clothes[i][1], comb.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        // 핵심 ...
        for(String type : comb.keySet()) {
            answer *= (comb.get(type) + 1); // 입는 경우, 안 입는 경우
        }
        
        return answer - 1; // 아무것도 안 입는 경우 제외
    }
}