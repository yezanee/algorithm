import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0; // 지갑 가로의 최댓값
        int maxH = 0; // 지갑 세로의 최댓값

        for (int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]); // 긴 변을 가로로
            int h = Math.min(sizes[i][0], sizes[i][1]); // 짧은 변을 세로로
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }

        return maxW * maxH;
    }
}
