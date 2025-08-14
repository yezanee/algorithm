import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        Arrays.sort(s1);
        Arrays.sort(s2);
        
        for(int i = 0; i < s1.length; i++) {
            for(int j = 0; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}