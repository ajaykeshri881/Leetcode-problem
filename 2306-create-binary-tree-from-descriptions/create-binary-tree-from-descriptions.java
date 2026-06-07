/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, TreeNode> map;
    Set<Integer> childs;

    public void solve(int []arr, Map<Integer, TreeNode> map){
        int parent = arr[0];
        int child = arr[1];
        int isLeft = arr[2];

        TreeNode p_node, c_node;

        if(map.containsKey(parent)){
            p_node = map.get(parent);
        }
        else {
            p_node = new TreeNode(parent);
            map.put(parent, p_node);
        }

        if(map.containsKey(child)){
            c_node = map.get(child);
        }
        else {
            c_node = new TreeNode(child);
            map.put(child, c_node);
        }

        if(isLeft == 1){
            p_node.left = c_node;
        }
        else p_node.right = c_node;
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        childs = new HashSet<>();

        for(int []desc : descriptions){
            childs.add(desc[1]);
            solve(desc, map);
        }

        for(int []desc : descriptions){
            if(!childs.contains(desc[0])){
                return map.get(desc[0]);
            }
        }

        return null;
    }
}