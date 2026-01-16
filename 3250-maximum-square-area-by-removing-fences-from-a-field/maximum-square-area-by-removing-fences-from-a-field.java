class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;

        int[] h = java.util.Arrays.copyOf(hFences, hFences.length + 2);
        int[] v = java.util.Arrays.copyOf(vFences, vFences.length + 2);

        h[hFences.length] = 1;
        h[hFences.length + 1] = m;
        v[vFences.length] = 1;
        v[vFences.length + 1] = n;

        java.util.Arrays.sort(h);
        java.util.Arrays.sort(v);

        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                set.add(h[j] - h[i]);
            }
        }

        long max = 0;

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int d = v[j] - v[i];
                if (set.contains(d)) {
                    if (d > max) max = d;
                }
            }
        }

        if (max == 0) return -1;

        return (int) ((max * max) % MOD);
    }
}
