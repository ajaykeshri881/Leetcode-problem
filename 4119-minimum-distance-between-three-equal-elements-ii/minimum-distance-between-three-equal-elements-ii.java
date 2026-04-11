class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for (List<Integer> list : map.values()) {
            int m = list.size();
            if (m < 3) continue;

            for (int i = 0; i + 2 < m; i++) {
                int k = list.get(i + 2);
                int start = list.get(i);
                ans = Math.min(ans, 2 * (k - start));
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}