class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 0, high = Math.min(tasks.length, workers.length);

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (canAssign(mid, tasks, workers, pills, strength)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = workers.length - k; i < workers.length; i++) {
            map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
        }

        int remainingPills = pills;

        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];

            Integer worker = map.ceilingKey(task);

            if (worker != null) {
                remove(map, worker);
            } else {
                if (remainingPills == 0) return false;

                worker = map.ceilingKey(task - strength);

                if (worker == null) return false;

                remove(map, worker);
                remainingPills--;
            }
        }

        return true;
    }

    private void remove(TreeMap<Integer, Integer> map, int key) {
        int count = map.get(key);

        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}