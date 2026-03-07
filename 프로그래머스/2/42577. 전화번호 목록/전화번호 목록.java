import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        for(String s : phone_book) {
            set.add(s);
        }
        
        for(int i=0; i<phone_book.length; i++) {
            String now = phone_book[i];
            
            for(int j=0; j<now.length(); j++) {
                if(set.contains(now.substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }
}