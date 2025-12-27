class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> free = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? (int)(a[1] - b[1]) : (a[0] < b[0] ? -1 : 1)
        );

        int[] used = new int[n];

        for (int i = 0; i < n; i++) free.add(i);
        for (int[] m : meetings) {
            long start = m[0], end = m[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add((int) busy.poll()[1]);
            }
            if (!free.isEmpty()) {
                int room = free.poll();
                busy.add(new long[]{end, room});
                used[room]++;
            } else {
                long[] r = busy.poll();
                long newEnd = r[0] + (end - start);
                busy.add(new long[]{newEnd, r[1]});
                used[(int) r[1]]++;
            }
        }
        
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (used[i] > used[ans]) ans = i;
        }
        return ans;
    }
}