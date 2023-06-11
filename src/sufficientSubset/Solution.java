package sufficientSubset;

/**
 * @author: ffzs
 * @Date: 2023/5/22 上午6:20
 *     1
 *   2   -3
 * -5   4
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

    int limit;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        int v = dfs(root, 0);
        if (v < limit) return null;
        return root;
    }

    private int dfs (TreeNode node, int total) {
        if (node.left == null && node.right == null) return total + node.val;
        int r = Integer.MIN_VALUE, l = Integer.MIN_VALUE;
        if (node.left != null) {
            l = dfs(node.left, node.val + total);
        }

        if (node.right != null) {
            r = dfs(node.right, node.val + total);
        }

        if (l < limit) node.left = null;
        if (r < limit) node.right = null;

        return Math.max(l, r);
    }

}
