import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long totalTimes = 0;
        Arrays.sort(times); // 시간 배열 오름차순 정렬
        long low = 0;
        long high = times[times.length - 1] * (long)n;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long examineNums = 0;
            for (int i = 0; i < times.length; i++) {
                examineNums += mid / times[i];
            }
            
            if(examineNums < n) low = mid + 1;
            else { totalTimes = mid; high = mid - 1;}
        }
        
        return totalTimes;
    }
}