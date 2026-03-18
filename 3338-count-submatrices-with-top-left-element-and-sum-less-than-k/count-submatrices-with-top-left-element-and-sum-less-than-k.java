class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0,m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                grid[i][j] += grid[i][j-1];
            }
        }
        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j] += grid[i-1][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]<=k)
                {
                    count++;
                }
            }
        }
        return count;
    }
}