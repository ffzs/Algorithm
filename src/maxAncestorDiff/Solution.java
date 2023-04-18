package maxAncestorDiff;

/**
 * @author: ffzs
 * @Date: 2023/4/18 下午12:25
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
    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs (TreeNode node, int max, int min) {
        if (node == null) return;

        dfs(node.left, Math.max(max, node.val), Math.min(min, node.val));
        res = Math.max(res, Math.abs(max - node.val));
        res = Math.max(res, Math.abs(min - node.val));
        dfs(node.right, Math.max(max, node.val), Math.min(min, node.val));
    }

}
