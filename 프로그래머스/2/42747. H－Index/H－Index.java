import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int h = 0;
        
        Arrays.sort(citations);
        
        while (true) {
            int count = 0;
            
            for(int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) {
                    count++;
                }
            }
            
            if (count >= h) {
                h++;
            } else {
                return --h;
            }
        }
    }
}