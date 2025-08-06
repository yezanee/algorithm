import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        
        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number))
                answer++;
        }
        
        // 3. 소수의 개수를 반환한다.
        return answer;
    }
    
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
            set.add(Integer.valueOf(comb));
        
        // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
        }
    }
    
    public boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if (num == 0 || num == 1) 
            return false;
        
        // 2. 에라토스테네스 체의 limit을 계산한다.
        int limit = (int)Math.sqrt(num);
        
        // 3. 에라토스테네스 체에 따라 limit까지만 배수 여부를 확인한다.
        for(int i = 2; i <= limit; i++) {
            if (num % i == 0)
                return false;
        }
        
        return true;
    }
}