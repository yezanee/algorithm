class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxLength = 0;
        int minArea = 0;
        
        for(int i = 0; i < sizes.length; i++) {
            int shorter = Math.min(sizes[i][0], sizes[i][1]);
            int longer = Math.max(sizes[i][0], sizes[i][1]);
            
            if(shorter > maxWidth) maxWidth = shorter;
            if(longer > maxLength) maxLength = longer;
        }
        
        minArea = maxWidth * maxLength;
        
    
        return minArea;
    }
}