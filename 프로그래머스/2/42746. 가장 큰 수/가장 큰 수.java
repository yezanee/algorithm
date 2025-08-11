import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] intToString = new String[numbers.length];
        
        // 1. int → String 변환
        for (int i = 0; i < numbers.length; i++) {
            intToString[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 정렬
        Arrays.sort(intToString, (a, b) -> (b + a).compareTo(a + b));
        
         // 3. 가장 큰 수가 0이면 (즉, 전부 0이면) 0 반환
        if (intToString[0].equals("0")) return "0";
        
        // 4. 이어 붙이기
        StringBuilder sb = new StringBuilder();
        for (String s : intToString) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}
