class Trie {
    Trie[] child = new Trie[26];
    int id = -1;
}

class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;
    
 
    private int add(Trie node, String word, int[] index) {
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.child[i] == null) {
                node.child[i] = new Trie();
            }
            node = node.child[i];
        }
        if (node.id == -1) {
            node.id = ++index[0];
        }
        return node.id;
    }
    
    public long minimumCost(String source, String target, 
                           String[] original, String[] changed, 
                           int[] cost) {
        int n = source.length();
        int m = original.length;
        
        Trie root = new Trie();
        int[] nextId = {-1};  
        
        int maxNodes = m * 2;
        int[][] dist = new int[maxNodes][maxNodes];
        
       
        for (int i = 0; i < maxNodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        for (int i = 0; i < m; i++) {
            int u = add(root, original[i], nextId);
            int v = add(root, changed[i], nextId);

            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }
        
        int nodeCount = nextId[0] + 1;
      
        for (int k = 0; k < nodeCount; k++) {
            for (int i = 0; i < nodeCount; i++) {
                if (dist[i][k] == INF) continue;
                for (int j = 0; j < nodeCount; j++) {
                    if (dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
     
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        
        for (int j = 0; j < n; j++) {
            
            long base = (j == 0) ? 0 : dp[j - 1];
            if (j > 0 && dp[j - 1] == -1) {
                continue; 
            }
            
        
            if (source.charAt(j) == target.charAt(j)) {
                if (dp[j] == -1) {
                    dp[j] = base;
                } else {
                    dp[j] = Math.min(dp[j], base);
                }
            }
        
            Trie nodeSrc = root;
            Trie nodeTgt = root;
            
            for (int i = j; i < n; i++) {
                char srcChar = source.charAt(i);
                char tgtChar = target.charAt(i);
                
          
                nodeSrc = nodeSrc.child[srcChar - 'a'];
              
                nodeTgt = nodeTgt.child[tgtChar - 'a'];
                
                if (nodeSrc == null || nodeTgt == null) {
                    break; 
                }
                
                if (nodeSrc.id != -1 && nodeTgt.id != -1) {
                    int costTransform = dist[nodeSrc.id][nodeTgt.id];
                    if (costTransform != INF) {
                        long newCost = base + costTransform;
                        if (dp[i] == -1 || newCost < dp[i]) {
                            dp[i] = newCost;
                        }
                    }
                }
            }
        }
        
        return dp[n - 1];
    }
}