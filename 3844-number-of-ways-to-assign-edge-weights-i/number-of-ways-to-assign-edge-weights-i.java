class Solution {
    static final int MOD = 1_000_000_007;
    int maxDepth = 0;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(1, 0, 0, graph);

        return power(2, maxDepth - 1);
    }

    private void dfs(int node, int parent, int depth, List<Integer>[] graph) {
        maxDepth = Math.max(maxDepth, depth);

        for (int next : graph[node]) {
            if (next != parent) {
                dfs(next, node, depth + 1, graph);
            }
        }
    }

    private int power(long a, int b) {
        long ans = 1;

        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }

            a = a * a % MOD;
            b >>= 1;
        }

        return (int) ans;
    }
}