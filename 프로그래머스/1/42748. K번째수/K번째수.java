import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int l=0; l<commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];
            
            int[] subArr = new int[j - i + 1];
            int idx=0;
            
            for(int n=i-1; n<j; n++) {
                subArr[idx] = array[n];
                idx++;
            }
            
            Arrays.sort(subArr);
            
            answer[l] = subArr[k-1];
        }
        
        return answer;
    }
}