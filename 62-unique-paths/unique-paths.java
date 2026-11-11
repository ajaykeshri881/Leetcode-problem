class Solution {

    public int find(int i,int m,int j, int n,int dp[][]){

        if(i == m-1 && j == n-1) return dp[m-1][n-1] = 1;
        if(i == m || j ==n) return 0;

        if(dp[i][j] != 0) return dp[i][j];

        return dp[i][j] = find(i+1,m,j,n,dp) + find(i,m,j+1,n,dp);
    }
    public int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];
        return find(0,m,0,n,dp);
    }
}