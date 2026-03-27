class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int[] shifted = new int[n];

            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {
                    // left shift
                    shifted[j] = mat[i][(j + k) % n];
                } else {
                    // right shift
                    shifted[j] = mat[i][(j - k % n + n) % n];
                }
            }

            // compare
            for (int j = 0; j < n; j++) {
                if (shifted[j] != mat[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}