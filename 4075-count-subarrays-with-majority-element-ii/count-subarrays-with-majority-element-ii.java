class Solution {

    class BIT {
        long[] tree;
        int n;
        BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        void update(int idx, long val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] pref = new long[n + 1];

        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + (nums[i] == target ? 1 : -1);
        }

        long[] sorted = pref.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> compress = new HashMap<>();
        int idx = 1;

        for (long x : sorted) {
            if (!compress.containsKey(x)) {
                compress.put(x, idx++);
            }
        }

        BIT bit = new BIT(idx);

        long ans = 0;

        for (long x : pref) {
            int pos = compress.get(x);

            // number of previous prefix sums smaller than current
            ans += bit.query(pos - 1);

            bit.update(pos, 1);
        }

        return ans;
    }
}