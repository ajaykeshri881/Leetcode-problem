class Solution {

    static final int MOD = 1_000_000_007;
    Long[][][] dp;

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new Long[zero + 1][one + 1][2];

        long ans = (solve(zero, one, limit, 0) +
                    solve(zero, one, limit, 1)) % MOD;

        return (int) ans;
    }

    long solve(int z, int o, int limit, int last) {

        if (z == 0 && o == 0) return 1;

        if (dp[z][o][last] != null) return dp[z][o][last];

        long ways = 0;

        if (last == 0) {
            for (int k = 1; k <= limit && o - k >= 0; k++) {
                ways = (ways + solve(z, o - k, limit, 1)) % MOD;
            }
        } 
        else {
            for (int k = 1; k <= limit && z - k >= 0; k++) {
                ways = (ways + solve(z - k, o, limit, 0)) % MOD;
            }
        }

        return dp[z][o][last] = ways;
    }
}