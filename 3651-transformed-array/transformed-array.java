class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int steps = nums[i];
            if (steps == 0) {
                result[i] = 0;
            } else {
                int target = (i + (steps % n) + n) % n;
                result[i] = nums[target];
            }
        }
        return result;
    }
}


// class Solution {
//     public int[] constructTransformedArray(int[] nums) {
//         int n = nums.length;
//         int[] result = new int[n];

//         for (int i = 0; i < n; i++) {
//             int steps = nums[i];
//             if (steps == 0) {
//                 result[i] = 0;
//                 continue;
//             }
//             int cur = i;
//             if (steps > 0) {
//                 for (int k = 0; k < steps; k++) {
//                     cur = (cur + 1) % n;
//                 }
//             } else {
//                 for (int k = 0; k < -steps; k++) {
//                     cur = (cur - 1 + n) % n;
//                 }
//             }
//             result[i] = nums[cur];
//         }
//         return result;
//     }
// }
