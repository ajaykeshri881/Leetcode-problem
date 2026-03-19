class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 0;

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < m; i++) {
            int rx = 0, ry = 0;

            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') rx++;
                else if (grid[i][j] == 'Y') ry++;

                x[j] += rx;
                y[j] += ry;

                if (x[j] == y[j] && x[j] > 0) {
                    ans++;
                }
            }
        }

        return ans;
    }
}