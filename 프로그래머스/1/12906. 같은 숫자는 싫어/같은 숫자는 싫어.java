import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i : arr) {
            if(!stack.isEmpty() && i == stack.peek()) continue;
            stack.push(i);
        }

        return stack;
    }
}