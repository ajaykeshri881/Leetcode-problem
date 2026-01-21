class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int x = nums.get(i);

            if ((x & (x - 1)) == 0) {
                ans[i] = -1;
                continue;
            }

            int temp = x;
            int trailingOnes = 0;

            while ((temp & 1) == 1) {
                trailingOnes++;
                temp >>= 1;
            }

            ans[i] = x - (1 << (trailingOnes - 1));
        }

        return ans;
    }
}
