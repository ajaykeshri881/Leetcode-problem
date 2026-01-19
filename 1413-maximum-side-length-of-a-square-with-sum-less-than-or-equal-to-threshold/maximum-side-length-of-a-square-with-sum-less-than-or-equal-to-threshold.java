class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] premat = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                premat[i + 1][j + 1] = mat[i][j]
                        + premat[i + 1][j]
                        + premat[i][j + 1]
                        - premat[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        for (int k = maxSize; k >= 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    int sum = premat[i + k][j + k]
                            - premat[i][j + k]
                            - premat[i + k][j]
                            + premat[i][j];

                    if (sum <= threshold) {
                        return k;
                    }
                }
            }
        }

        return 0;
    }
}