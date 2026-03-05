import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int N = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }
        
        return Math.min(set.size(), N);
    }
}