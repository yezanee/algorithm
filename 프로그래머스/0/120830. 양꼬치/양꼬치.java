class Solution {
    public int solution(int n, int k) {
        int sheep = 12000 * n;
        int cnt = n / 10;
        int drink = 2000 * (k - cnt);
        
        int answer = sheep + drink;
        
        return answer;
    }
}