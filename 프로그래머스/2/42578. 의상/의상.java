import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        for(int v : map.values()) {
            answer *= (v + 1); // 안 입는 경우의 수도 포함
        }
        
        return answer - 1; // 아무것도 안 입는 경우 빼기
    }
}