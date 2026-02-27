import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int N = (nums.length) / 2; // 가져갈 수 있는 폰켓몬 수
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }
        
        return Math.min(set.size(), N);
    }
}