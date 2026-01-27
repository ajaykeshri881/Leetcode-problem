class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        List<List<int[]>> revAdj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            revAdj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            revAdj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        int[][] switchedDist = new int[n][2];
        for (int[] row : switchedDist) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        switchedDist[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0];
            int node = top[1];
            int state = top[2];
            
            if (cost > switchedDist[node][state]) continue;
            
            if (state == 0) {
                for (int[] next : adj.get(node)) {
                    int nextNode = next[0];
                    int newCost = cost + next[1];
                    if (newCost < switchedDist[nextNode][0]) {
                        switchedDist[nextNode][0] = newCost;
                        pq.offer(new int[]{newCost, nextNode, 0});
                    }
                }
              
                for (int[] next : revAdj.get(node)) {
                    int nextNode = next[0];
                    int newCost = cost + 2 * next[1];
                    if (newCost < switchedDist[nextNode][1]) {
                        switchedDist[nextNode][1] = newCost;
                        pq.offer(new int[]{newCost, nextNode, 1});
                    }
                }
            } else {
                for (int[] next : adj.get(node)) {
                    int nextNode = next[0];
                    int newCost = cost + next[1];
                    if (newCost < switchedDist[nextNode][1]) {
                        switchedDist[nextNode][1] = newCost;
                        pq.offer(new int[]{newCost, nextNode, 1});
                    }
                }
                for (int[] next : revAdj.get(node)) {
                    int nextNode = next[0];
                    int newCost = cost + 2 * next[1];
                    if (newCost < switchedDist[nextNode][1]) {
                        switchedDist[nextNode][1] = newCost;
                        pq.offer(new int[]{newCost, nextNode, 1});
                    }
                }
            }
        }
        
        int ans = Math.min(switchedDist[n-1][0], switchedDist[n-1][1]);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}