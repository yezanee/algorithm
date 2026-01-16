import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String key : participant) {
            if (map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
            } else {
                map.put(key, 1);   
            }
        }
        
        for(String key : completion) {
            if(map.containsKey(key)) {
                map.replace(key, map.get(key) - 1);
            }
        }
        
        for(String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return "";
    }
}