class Solution {
    public int numMagicSquaresInside(int[][] arr) {
        int n = arr.length, m = arr[0].length, count = 0;
        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                if (arr[i + 1][j + 1] != 5) continue;
                int a = arr[i][j],     b = arr[i][j + 1],     c = arr[i][j + 2];
                int d = arr[i + 1][j], e = arr[i + 1][j + 1], f = arr[i + 1][j + 2];
                int h = arr[i + 2][j], k = arr[i + 2][j + 1], l = arr[i + 2][j + 2];
                boolean[] seen = new boolean[10];
                int[] vals = {a, b, c, d, e, f, h, k, l};
                for (int v : vals) {
                    if (v < 1 || v > 9 || seen[v]) {
                        seen = null;
                        break;
                    }
                    seen[v] = true;
                }
                if (seen == null) continue;
                if (a + b + c == 15 &&
                    d + e + f == 15 &&
                    h + k + l == 15 &&
                    a + d + h == 15 &&
                    b + e + k == 15 &&
                    c + f + l == 15 &&
                    a + e + l == 15 &&
                    c + e + h == 15) {
                    count++;
                }
            }
        }
        return count;
    }
}