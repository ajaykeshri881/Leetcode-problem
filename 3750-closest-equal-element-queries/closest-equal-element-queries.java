

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        List<Integer> res = new ArrayList<>();
        
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);
            
            if (list.size() == 1) {
                res.add(-1);
                continue;
            }
            
            int idx = Collections.binarySearch(list, q);
            
            int prev = list.get((idx - 1 + list.size()) % list.size());
            int next = list.get((idx + 1) % list.size());
            
            int d1 = Math.abs(q - prev);
            d1 = Math.min(d1, n - d1);
            
            int d2 = Math.abs(q - next);
            d2 = Math.min(d2, n - d2);
            
            res.add(Math.min(d1, d2));
        }
        
        return res;
    }
}