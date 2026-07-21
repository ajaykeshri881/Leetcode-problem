class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length, total = m * n;
        int[][] ans = new int[m][n];
        k %= total;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int idx = (i * n + j + k) % total;
                ans[idx / n][idx % n] = grid[i][j];
            }

        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : ans) {
            List<Integer> list = new ArrayList<>();
            for (int x : row) list.add(x);
            res.add(list);
        }
        return res;
    }
}