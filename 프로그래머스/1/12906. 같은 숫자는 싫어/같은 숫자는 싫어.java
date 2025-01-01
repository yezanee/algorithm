import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] temAnswer = new int[arr.length];
        int cnt = 1;
        temAnswer[0] = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i-1] == arr[i]) { continue; }
            else { temAnswer[cnt++] = arr[i]; }
        }
        
        int[] answer = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            answer[i] = temAnswer[i];
        }

        return answer;
    }
}