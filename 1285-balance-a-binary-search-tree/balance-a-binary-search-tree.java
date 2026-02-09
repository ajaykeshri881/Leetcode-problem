class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return build(list, 0, list.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (null == root) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private TreeNode build(List<Integer> list, int start, int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = build(list, start, mid - 1);
        node.right = build(list, mid + 1, end);
        return node;
    }
}