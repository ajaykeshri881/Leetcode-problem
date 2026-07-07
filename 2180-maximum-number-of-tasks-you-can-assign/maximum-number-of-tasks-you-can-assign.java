class Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    int lowerBound(int[] arr, int l, int r, int target) {
        int ans = r + 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 0;
        int high = Math.min(tasks.length, workers.length);
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAssign(mid, tasks, workers, pills, strength)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {

        if (k == 0) return true;

        int m = workers.length;
        int offset = m - k;
        int usedPills = 0;

        parent = new int[k + 1];
        for (int i = 0; i <= k; i++)
            parent[i] = i;

        for (int i = k - 1; i >= 0; i--) {

            int idx = lowerBound(workers, offset, m - 1, tasks[i]);
            idx = find(idx - offset);

            if (idx < k) {
                parent[idx] = find(idx + 1);
            } else {

                idx = lowerBound(workers, offset, m - 1, tasks[i] - strength);
                idx = find(idx - offset);

                if (idx < k) {
                    usedPills++;
                    parent[idx] = find(idx + 1);
                } else {
                    return false;
                }
            }
        }

        return usedPills <= pills;
    }
}