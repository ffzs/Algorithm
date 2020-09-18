package sumOfLeftLeaves;

/**
 * @author: ffzs
 * @Date: 2020/9/19 上午7:05
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dfs(root, false);
        return res;
    }

    private void dfs (TreeNode root, boolean isLeft) {

        if (root.right == null && root.left == null && isLeft) {
            res += root.val;
        }

        if (root.left != null) dfs(root.left, true);
        if (root.right != null) dfs(root.right, false);
    }
}
