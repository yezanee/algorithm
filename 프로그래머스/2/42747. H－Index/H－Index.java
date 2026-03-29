import java.util.*;

class Solution {
    public int solution(int[] citations) {        
        int n = citations.length;
        Arrays.sort(citations);
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            int h = n - i;
            
            if(citations[i] >= h) {
                return h;
            }
        }
        
        return answer;
    }
}