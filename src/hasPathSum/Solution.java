package hasPathSum;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/7
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.right == null && root.left == null) return sum == 0;
        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}
