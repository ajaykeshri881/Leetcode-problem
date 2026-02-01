// class Solution {
//     public int minimumCost(int[] nums) {
//         int n = nums.length;

//         int min1 = Integer.MAX_VALUE;
//         int min2 = Integer.MAX_VALUE;
//         for (int i = 1; i < n; i++) {
//             int x = nums[i];
//             if (x < min1) {
//                 min2 = min1;
//                 min1 = x;
//             } else if (x < min2) {
//                 min2 = x;
//             }
//         }

//         return nums[0] + min1 + min2;
//     }
// }
class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int cost = nums[0] + nums[i] + nums[j];
                ans = Math.min(ans, cost);
            }
        }
        return ans;
    }
}
