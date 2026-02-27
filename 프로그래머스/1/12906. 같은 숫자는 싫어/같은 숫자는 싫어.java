import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int idx = 0;
        
        answer[idx] = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == answer[idx]) continue;
            else {
                idx++;
                answer[idx] = arr[i];   
            }
        }
        
        int[] result = new int[idx+1];
        
        for(int i=0; i<=idx; i++) {
            result[i] = answer[i];
        }

        return result;
    }
}