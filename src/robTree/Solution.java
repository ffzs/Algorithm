package robTree;

/**
 * @author: ffzs
 * @Date: 2020/8/5 上午7:10
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;


        int left = 0, right = 0;
        if (root.left != null) left = rob(root.left.left) + rob(root.left.right);
        if (root.right != null) right = rob(root.right.left) + rob(root.right.right);

        return Math.max(root.val+left+right, rob(root.left) + rob(root.right));
    }
}
