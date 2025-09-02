class Solution {
    public int solution(int[] numbers, int target) {
        
        return dfs(numbers, 0, 0, target);
    }
    
    // 깊이 우선 탐색으로 모든 +/- 조합을 탐색
    public int dfs(int[] numbers, int idx, int sum, int target) {
        
        // 모든 숫자를 다 썼다면, 합이 target인지 확인
        if (idx == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        
        // 현재 숫자를 더하는 경우
        int count = dfs(numbers, idx + 1, sum + numbers[idx], target);
        
        // 현재 숫자를 빼는 경우
        count += dfs(numbers, idx + 1, sum - numbers[idx], target);
        
        return count;
    }
}