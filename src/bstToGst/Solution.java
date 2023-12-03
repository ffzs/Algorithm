package bstToGst;

/**
 * @author: ffzs
 * @Date: 2023/12/4 上午7:05
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
    int total = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs (TreeNode node) {
        if (node == null) return;

        dfs(node.right);
        total += node.val;
        node.val = total;
        dfs(node.left);
    }

}
