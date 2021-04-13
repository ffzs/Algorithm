package minDiffInBST;

/**
 * @author: ffzs
 * @Date: 2021/4/13 上午7:50
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

    private Integer pre, res;
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    private void dfs (TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (pre == null) pre = root.val;
        else res = Math.min(res, root.val-pre);
        pre = root.val;
        dfs(root.right);
    }
}
