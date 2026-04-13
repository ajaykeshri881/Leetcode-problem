class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        
        for (int dist = 0; dist < n; dist++) {
            if (start - dist >= 0 && nums[start - dist] == target) {
                return dist;
            }
            if (start + dist < n && nums[start + dist] == target) {
                return dist;
            }
        }
        
        return -1; 
    }
}

/* class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int minDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                minDist = Math.min(minDist, Math.abs(i - start));
            }
        }
        
        return minDist;
    }
} */