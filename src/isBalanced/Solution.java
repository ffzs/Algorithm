package isBalanced;

/**
 * @author: ffzs
 * @Date: 2020/8/17 上午8:46
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalanced(root, 0);
        return isBalanced;
    }

    private int isBalanced(TreeNode root, int level) {
        if (root == null) return level - 1;

        int left = isBalanced(root.left, level + 1);
        int right = isBalanced(root.right, level + 1);
        if (Math.abs(left-right)>1) isBalanced = false;
        return Math.max(left, right);
    }
}
