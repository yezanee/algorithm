import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        // 최소 힙으로 교체 (정렬 반복 제거)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
          for (int s : scoville) pq.offer(s);

           // 두 개 이상 있고, 최솟값이 K 미만인 동안만 섞기
           while (pq.size() > 1 && pq.peek() < K) {
           int a = pq.poll();      // 최솟값
            int b = pq.poll();      // 두 번째 최솟값
            pq.offer(a + 2 * b);    // 새 음식 삽입
            cnt++;
        }

        // 모두 K 이상인지 최종 검증
        return (pq.peek() != null && pq.peek() >= K) ? cnt : -1;
    }
}