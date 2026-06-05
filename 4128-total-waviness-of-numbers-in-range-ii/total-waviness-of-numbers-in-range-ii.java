class Solution {
    Long[][][][] dp;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        String s = Long.toString(n);
        dp = new Long[s.length()][11][11][s.length() + 1];

        return dfs(0, 10, 10, 0, true, false, s);
    }

    private long dfs(int idx, int prev2, int prev1, int wave,
                     boolean tight, boolean start, String s) {

        if (idx == s.length()) {
            return wave;
        }

        if (!tight && start && dp[idx][prev2][prev1][wave] != null) {
            return dp[idx][prev2][prev1][wave];
        }

        int limit = tight ? s.charAt(idx) - '0' : 9;
        long ans = 0;

        for (int d = 0; d <= limit; d++) {

            boolean ns = start || d != 0;

            if (!ns) {
                ans += dfs(idx + 1, 10, 10, 0,
                        tight && d == limit, false, s);
            } else {
                int add = 0;

                if (prev2 != 10) {
                    if ((prev1 > prev2 && prev1 > d) ||
                        (prev1 < prev2 && prev1 < d)) {
                        add = 1;
                    }
                }

                ans += dfs(idx + 1, prev1, d,
                        wave + add,
                        tight && d == limit, true, s);
            }
        }

        if (!tight && start) {
            dp[idx][prev2][prev1][wave] = ans;
        }

        return ans;
    }
}