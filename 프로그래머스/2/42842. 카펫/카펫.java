class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 전체 타일 수
        
        // 세로 h는 최소 3부터 (테두리 제외 높이 1 이상) -> 노란 타일 존재 위해
        for (int h = 3; h <= total; h++) {
            if (total % h != 0) continue;  // 전체 면적을 나눌 수 있는 세로만 후보 (w 정수가 되게 하기 위해)
            
            int w = total / h; // 가로 길이 계산 (w * h = total에서 파생)
            
            if (w < h) break; // (가로 >= 세로)만 탐색

            // 테두리를 제외한 내부가 노란 타일 수와 일치해야 함
            if ((w - 2) * (h - 2) == yellow) {
                return new int[]{w, h};    // 가로, 세로 순
            }
        }
        
        return 0; // 문제 조건상 여기 도달하지 않음
    }
}