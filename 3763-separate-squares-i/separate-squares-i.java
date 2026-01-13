class Solution {
    public double separateSquares(int[][] squares) {
        double low = 1e9, high = -1e9;
        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
        }
        for (int i = 0; i < 50; i++) {
            double mid = (low + high) / 2;
            double below = 0, above = 0;

            for (int[] s : squares) {
                double y = s[1];
                double side = s[2];
                if (mid <= y) {
                    above += side * side;
                } else if (mid >= y + side) {
                    below += side * side;
                } else {
                    below += (mid - y) * side;
                    above += (y + side - mid) * side;
                }
            }
            if (below < above) low = mid;
            else high = mid;
        }
        return (low + high) / 2;
    }
}
