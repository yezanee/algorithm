import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack();
        
        for(int i : arr) {
            if(stack.size() == 0) stack.push(i);
            if (stack.size() > 0 && stack.peek() != i) stack.push(i);
        }

        return stack;
    }

}