
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        long[] arr = new long[n];

        for(List<Integer> list : map.values()) {
            int size = list.size();

            long preSum = 0;
            for(int i=0; i<size; i++) {
                int idx = list.get(i);
                arr[idx] += (long)i * idx - preSum;
                preSum += idx;
            }

            long suffSum = 0;
            for(int i=size-1; i>=0; i--) {
                int idx = list.get(i);
                arr[idx] += suffSum - (long)(size - 1 - i) * idx;
                suffSum += idx;
            }
        }

        return arr;
    }
} 