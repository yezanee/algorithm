import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.substring(i, i+1).equals("(")) {
                stack.push(1);
            } else if (s.substring(i, i+1).equals(")")) {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();   
                }
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
}