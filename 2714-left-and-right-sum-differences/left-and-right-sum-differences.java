class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length, sum = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            sum += nums[i];
        }
        left[0] = 0;
        right[0] = sum - nums[0];
        ans[0] = Math.abs(left[0] - right[0]);

        for(int i=1; i<n; i++){
            left[i] = left[i-1] + nums[i-1];
            right[i] = right[i-1] - nums[i];
            ans[i] = Math.abs(left[i] - right[i]);
        }
        return ans;
        
    }
}