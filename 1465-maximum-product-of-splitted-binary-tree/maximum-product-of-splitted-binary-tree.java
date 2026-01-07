class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);
    }

    private long getSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getSum(node.left) + getSum(node.right);
    }

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long leftSum = dfs(node.left);
        long rightSum = dfs(node.right);

        long subTreeSum = node.val + leftSum + rightSum;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
