// class Solution {
//     public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
//         Arrays.sort(tasks);
//         Arrays.sort(workers);

//         int low = 0, high = Math.min(tasks.length, workers.length);

//         while (low < high) {
//             int mid = low + (high - low + 1) / 2;

//             if (canAssign(mid, tasks, workers, pills, strength)) {
//                 low = mid;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return low;
//     }

//     private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {
//         TreeMap<Integer, Integer> map = new TreeMap<>();

//         for (int i = workers.length - k; i < workers.length; i++) {
//             map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
//         }

//         int remainingPills = pills;

//         for (int i = k - 1; i >= 0; i--) {
//             int task = tasks[i];

//             Integer worker = map.ceilingKey(task);

//             if (worker != null) {
//                 remove(map, worker);
//             } else {
//                 if (remainingPills == 0) return false;

//                 worker = map.ceilingKey(task - strength);

//                 if (worker == null) return false;

//                 remove(map, worker);
//                 remainingPills--;
//             }
//         }

//         return true;
//     }

//     private void remove(TreeMap<Integer, Integer> map, int key) {
//         int count = map.get(key);

//         if (count == 1) {
//             map.remove(key);
//         } else {
//             map.put(key, count - 1);
//         }
//     }
// }




class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int lo = 0, hi = Math.min(tasks.length, workers.length);

        while (lo < hi) {
            int mid = (lo + hi + 1) >> 1;

            if (can(tasks, workers, pills, strength, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private boolean can(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int t = 0;

        for (int w = workers.length - k; w < workers.length; w++) {
            while (t < k && tasks[t] <= workers[w] + strength) {
                dq.offerLast(tasks[t++]);
            }

            if (dq.isEmpty()) return false;

            if (dq.peekFirst() <= workers[w]) {
                dq.pollFirst();
            } else {
                if (pills == 0) return false;
                pills--;
                dq.pollLast();
            }
        }

        return true;
    }
}