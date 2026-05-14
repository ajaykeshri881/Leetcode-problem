class Solution {
    public boolean isGood(int[] nums) {

        Arrays.sort(nums);

        int n = nums[nums.length - 1];

        if (nums.length != n + 1) {
            return false;
        }
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        return nums[n - 1] == n && nums[n] == n;
    }
}


/* class Solution {
    public boolean isGood(int[] nums) {

        int n = 0;

        for (int x : nums) {
            n = Math.max(n, x);
        }

        if (nums.length != n + 1) {
            return false;
        }

        int[] freq = new int[n + 1];

        for (int x : nums) {
            if (x > n) {
                return false;
            }
            freq[x]++;
        }

        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }
        return freq[n] == 2;
    }
} */