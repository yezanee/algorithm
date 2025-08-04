import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        int i = 0;
        for(; i < participant.length - 1; i++) {
            if(!(participant[i].equals(completion[i]))) {
                break;
            }
        }
        
        return participant[i];
    }
}