import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> select = new HashSet<>();
        
        for (int num : nums) {
            select.add(num);
        }
        
        int maxSize = select.size();
        int selectMaxSize = nums.length / 2;
        
        return Math.min(maxSize, selectMaxSize);
     
    }
}
