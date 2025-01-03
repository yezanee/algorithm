import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int firstIdx = commands[i][0] - 1;
            int endIdx = commands[i][1] - 1;
            int selectIdx = commands[i][2] - 1;
            
            int[] splitArray = new int[endIdx - firstIdx + 1];
            
            for(int j = 0; j < splitArray.length; j++) {
                splitArray[j] = array[firstIdx++];
            }
            
            Arrays.sort(splitArray);
            
            answer[i] += splitArray[selectIdx];
        }
        
        return answer;
    }
}