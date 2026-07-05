class Solution {
    int n;
    int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board) {
        n = board.size();

        int[][][] dp = new int[n][n][2];

   
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j][0] = -2;
            }
        }

        dp[n-1][n-1][0] = 0;  
        dp[n-1][n-1][1] = 1; 

        int maxSum = Math.max(solve(board, 0, 0, dp), 0);

        return new int[]{maxSum, dp[0][0][1]};
    }

    private int solve(List<String> board, int i, int j, int[][][] dp) {
        if(i == n || j == n) return -1;

        if(board.get(i).charAt(j) == 'X') return -1;

        if(dp[i][j][0] != -2) return dp[i][j][0];

        int right = solve(board, i, j + 1, dp);
        int bottom = solve(board, i + 1, j, dp);
        int diag = solve(board, i + 1, j + 1, dp);

        int best = Math.max(Math.max(right, bottom), diag);


        if(best != -1) {
            dp[i][j][0] = best + (board.get(i).charAt(j) != 'E' ? board.get(i).charAt(j) - '0' : 0);

            if(right == best) {
                dp[i][j][1] += dp[i][j+1][1];
                dp[i][j][1] %= MOD;
            }

            if(bottom == best) {
                dp[i][j][1] += dp[i+1][j][1];
                dp[i][j][1] %= MOD;
            }

            if(diag == best) {
                dp[i][j][1] += dp[i+1][j+1][1];
                dp[i][j][1] %= MOD;
            }
        } else {
            dp[i][j][0] = -1;
        }

        return dp[i][j][0];
    }
}