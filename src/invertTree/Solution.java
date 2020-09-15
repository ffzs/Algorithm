package invertTree;

/**
 * @author: ffzs
 * @Date: 2020/9/16 上午7:07
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode res = new TreeNode(root.val);
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode root, TreeNode res) {
        if (root.left != null) {
            res.right = new TreeNode(root.left.val);
            dfs(root.left, res.right);
        }
        if (root.right != null) {
            res.left = new TreeNode(root.right.val);
            dfs(root.right, res.left);
        }
    }
}
