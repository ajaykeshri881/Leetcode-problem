class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = -(int)1e9;
        int min = (int)1e9;

        for(int val : nums){
            max = Math.max(max, val);
            min = Math.min(min, val);
        }

        return (long)(max - min) * (long)k;
    }
}