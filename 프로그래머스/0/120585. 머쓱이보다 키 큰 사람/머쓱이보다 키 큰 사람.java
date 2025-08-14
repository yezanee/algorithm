import java.util.*;

class Solution {
    public int solution(int[] array, int height) {
        int cnt = 0;
        
        Arrays.sort(array);
        
        for(int i = 0; i < array.length; i++) {
            if (array[i] > height) {
                cnt++;
            }
        }
        
        return cnt;
    }
}