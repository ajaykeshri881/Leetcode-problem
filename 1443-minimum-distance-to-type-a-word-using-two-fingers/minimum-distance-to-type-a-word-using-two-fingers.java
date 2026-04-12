class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int total = 0;
        
        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            
            int dist = getDist(prev, cur);
            total += dist;
            
            for (int j = 0; j < 26; j++) {
                if (dp[i - 1][j] == -1) continue;
                
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                
                int gain = dp[i - 1][j] + dist - getDist(j, cur);
                dp[i][prev] = Math.max(dp[i][prev], gain);
            }
            
            dp[i][prev] = Math.max(dp[i][prev], dist);
        }
        
        int maxSave = 0;
        for (int j = 0; j < 26; j++) {
            maxSave = Math.max(maxSave, dp[n - 1][j]);
        }
        
        return total - maxSave;
    }
    private int getDist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}