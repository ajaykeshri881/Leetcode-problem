class Solution {
    static final int MOD = 1_000_000_007;
    int LOG = 17;
    int[][] up;
    int[] depth;
    java.util.List<Integer>[] graph;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        while ((1 << LOG) <= n) LOG++;

        graph = new java.util.ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new java.util.ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        up = new int[LOG][n + 1];
        depth = new int[n + 1];

        dfs(1, 1);

        for (int i = 1; i < LOG; i++) {
            for (int node = 1; node <= n; node++) {
                up[i][node] = up[i - 1][up[i - 1][node]];
            }
        }

        int maxDepth = n;
        long[] pow = new long[maxDepth + 1];
        pow[0] = 1;

        for (int i = 1; i <= maxDepth; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = getLCA(u, v);
            int len = depth[u] + depth[v] - 2 * depth[lca];

            if (len == 0)
                ans[i] = 0;
            else
                ans[i] = (int) pow[len - 1];
        }

        return ans;
    }

    void dfs(int node, int parent) {
        up[0][node] = parent;

        for (int next : graph[node]) {
            if (next == parent)
                continue;

            depth[next] = depth[node] + 1;
            dfs(next, node);
        }
    }

    int getLCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; i < LOG; i++) {
            if (((diff >> i) & 1) == 1)
                a = up[i][a];
        }

        if (a == b)
            return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[i][a] != up[i][b]) {
                a = up[i][a];
                b = up[i][b];
            }
        }

        return up[0][a];
    }
}