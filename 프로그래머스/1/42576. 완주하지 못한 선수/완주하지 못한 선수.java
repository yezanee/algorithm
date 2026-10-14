import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> nameMap = new HashMap<>();
        
        for(int i=0; i < participant.length; i++) {
            nameMap.put(participant[i], nameMap.getOrDefault(participant[i], 0) + 1);
        }
        
        for(int j=0; j < completion.length; j++) {
            nameMap.put(completion[j], nameMap.getOrDefault(completion[j], 0) - 1);
        }
        
        for(String str : nameMap.keySet()) {
            if(nameMap.get(str) > 0) return str;
        }
        return answer;
    }
}