// class Solution {
//     public int repeatedNTimes(int[] nums) {
//         HashSet<Integer> seen = new HashSet<>();
//         for (int num : nums) {
//             if (seen.contains(num)) {
//                 return num;
//             }
//             seen.add(num);
//         }
//         return -1; 
//     }
// }

class Solution {
    public int repeatedNTimes(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i+1] || nums[i] == nums[i+2]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}