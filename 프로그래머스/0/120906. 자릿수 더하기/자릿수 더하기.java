import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int n) {
        String num = Integer.toString(n);
        int answer = 0;
        
        if (n % 10 == 0) {
            return n;
        } else {
            for(int i = 0; i < num.length(); i++) {
                answer += Integer.parseInt(num.substring(i, i+1));
            }

            return answer;
               
        }
    }
}