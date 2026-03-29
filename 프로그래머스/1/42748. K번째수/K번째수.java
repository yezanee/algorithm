import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int subArrSize = commands[i][1] - commands[i][0] + 1;
            int[] subArr = new int[subArrSize];
            
            int index = 0;
            for(int j=commands[i][0]-1; j<commands[i][1]; j++) {
                subArr[index++] = array[j];
            }
            
            Arrays.sort(subArr);
            
            answer[i] = subArr[commands[i][2] - 1];
        }
        
        return answer;
    }
}