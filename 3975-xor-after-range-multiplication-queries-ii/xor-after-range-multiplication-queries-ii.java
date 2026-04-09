class Solution {
    private long power(long base, long exp) {
        long res = 1, mod = 1_000_000_007;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) 
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007;
        int n = nums.length;
        int square = (int) Math.sqrt(n) + 1;
        long[] numL = new long[n];
        for (int i = 0; i < n; i++) numL[i] = nums[i];

        Map<Integer, List<int[]>> small = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k >= square) {
                for (int idx = l; idx <= r; idx += k) 
                    numL[idx] = (numL[idx] * v) % MOD;
            } else {
                small.computeIfAbsent(k, x -> new ArrayList<>()).add(new int[]{l, r, v});
            }
        }

        long[] factors = new long[n];
        Arrays.fill(factors, 1);

        for (int k : small.keySet()) {
            List<int[]>[] events = new ArrayList[k];
            for (int i = 0; i < k; i++) 
                events[i] = new ArrayList<>();

            for (int[] q : small.get(k)) {
                int l = q[0], r = q[1], v = q[2];
                int res = l % k;
                int last = l + ((r - l) / k) * k;
                events[res].add(new int[]{l, v});
                if (last + k < n) {
                    events[res].add(new int[]{last + k, (int) power(v, MOD - 2)});
                }
            }

            for (int res = 0; res < k; res++) {
                events[res].sort(Comparator.comparingInt(a -> a[0]));
                long cur = 1;
                int ptr = 0;
                for (int i = res; i < n; i += k) {
                    while (ptr < events[res].size() && events[res].get(ptr)[0] == i) {
                        cur = (cur * events[res].get(ptr)[1]) % MOD;
                        ptr++;
                    }
                    factors[i] = (factors[i] * cur) % MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) 
            ans ^= (int) ((numL[i] * factors[i]) % MOD);
        return ans;
    }
}