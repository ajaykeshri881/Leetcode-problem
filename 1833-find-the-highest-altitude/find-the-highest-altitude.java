class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] altitude = new int[n + 1];

        for (int i = 0; i < n; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
        }

        int max = altitude[0];

        for (int i = 1; i <= n; i++) {
            if (altitude[i] > max) {
                max = altitude[i];
            }
        }

        return max;
    }
}