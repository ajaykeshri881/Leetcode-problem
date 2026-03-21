class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = 0; i < k / 2; i++) {
            int r1 = x + i;
            int r2 = x + k - 1 - i;

            for (int j = y; j < y + k; j++) {
                int temp = grid[r1][j];
                grid[r1][j] = grid[r2][j];
                grid[r2][j] = temp;
            }
        }

        return grid;
    }
}


/* class Solution {

    private void swapRows(int[][] grid, int r1, int r2, int y, int k) {
        for (int j = 0; j < k; j++) {
            int temp = grid[r1][y + j];
            grid[r1][y + j] = grid[r2][y + j];
            grid[r2][y + j] = temp;
        }
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = 0; i < k / 2; i++) {
            swapRows(grid, x + i, x + k - 1 - i, y, k);
        }

        return grid;
    }
} */

/*  class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int top = x;
        int bottom = x + k - 1;

        while (top < bottom) {
            for (int col = y; col < y + k; col++) {
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
} */
 

/* class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                int temp = grid[x + i][y + j];
                grid[x + i][y + j] = grid[x + k - 1 - i][y + j];
                grid[x + k - 1 - i][y + j] = temp;
            }
        }

        return grid;
    }
} */

/* class Solution {
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
} */