class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 12345;

        int size = m * n;
        long[] arr = new long[size];

        int idx = 0;
        for (int[] row : grid) {
            for (int val : row) {
                arr[idx++] = val;
            }
        }

        long[] prefix = new long[size];
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = (prefix[i - 1] * arr[i - 1]) % mod;
        }

        long suffix = 1;
        int[][] result = new int[m][n];

        for (int i = size - 1; i >= 0; i--) {
            long val = (prefix[i] * suffix) % mod;
            result[i / n][i % n] = (int) val;

            suffix = (suffix * arr[i]) % mod;
        }

        return result;
    }
}

/* class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int mod = 12345;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                long prod = 1;

                for (int x = 0; x < m; x++) {
                    for (int y = 0; y < n; y++) {
                        if (x == i && y == j) continue;
                        prod = (prod * grid[x][y]) % mod;
                    }
                }

                result[i][j] = (int) prod;
            }
        }

        return result;
    }
} */