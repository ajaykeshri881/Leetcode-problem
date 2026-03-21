class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] temp = new int[k][k];

        // copy
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                temp[i][j] = grid[x + i][y + j];
            }
        }

        // reverse vertically
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                grid[x + i][y + j] = temp[k - 1 - i][j];
            }
        }

        return grid;
    }
}