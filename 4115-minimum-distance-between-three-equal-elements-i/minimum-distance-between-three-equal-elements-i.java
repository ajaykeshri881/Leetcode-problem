class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            for (int i = 0; i + 2 < list.size(); i++) {
                int dist = 2 * (list.get(i + 2) - list.get(i));
                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

/* class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        ans = Math.min(ans, 
                            Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i));
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
} */