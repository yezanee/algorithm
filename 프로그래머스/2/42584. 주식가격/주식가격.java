import java.util.*;

class Solution {
    public int[] solution(int[] prices) { // 주식 가격이 담긴 배열 prices
		    int n = prices.length;
			  int[] answer = new int[n]; // 가격이 떨어지지 않은 기간 배열
			  Stack<Integer> stack = new Stack<>(); // 인덱스를 저장할 스택
			  
			  for(int i = 0; i < n; i++) {
						// 가격이 떨어지는 순간, stack에서 뺴면서 시간 계산
						while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
								int topIndex = stack.pop();
								answer[topIndex] = i - topIndex; // 현재 시점 - 저장된 시점
						}
						stack.push(i); // 현재 인덱스 저장	  
        }
        
        // 아직 스택에 남은 인덱스들은 끝까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            answer[topIndex] = n - 1 - topIndex;
        }
                
        return answer;
    }
}