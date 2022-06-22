package findBottomLeftValue;

/**
 * @author: ffzs
 * @Date: 2022/6/22 下午3:31
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Solution {
    int maxDepth, value;
    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 1;
        value = root.val;
        dfs(root,  1);
        return value;
    }

    private void dfs (TreeNode node, int depth) {
        if (node == null) return;
        if (node.left != null) dfs(node.left, depth + 1);
        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                value = node.val;
            }
        }
        if (node.right != null) dfs(node.right, depth + 1);
    }

}
