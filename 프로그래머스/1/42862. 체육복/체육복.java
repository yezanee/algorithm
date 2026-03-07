import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = lost.length;
        boolean[] isReserve = new boolean[reserve.length];
        Arrays.sort(reserve);
        
        HashSet<Integer> lostNums = new HashSet<>();
        
        for(int i : lost) {
            lostNums.add(i);
        }
        
        for(int i=0; i<reserve.length; i++) {
            if(lostNums.contains(reserve[i])) {
                isReserve[i] = true;
                count = count - 1;
                lostNums.remove(reserve[i]);
            }
        }
        
        for(int i=0; i<reserve.length; i++) {
            if(!isReserve[i] && lostNums.contains(reserve[i] - 1)) {
                isReserve[i] = true;
                count = count - 1;   
                lostNums.remove(reserve[i] - 1);
            } else if (!isReserve[i] && lostNums.contains(reserve[i] + 1)) {
                isReserve[i] = true;
                count = count - 1;
                lostNums.remove(reserve[i] + 1);
            }
        }
        
        return n - count;
    }
}