package mergeTrees;

/**
 * @author: ffzs
 * @Date: 2020/9/23 上午7:27
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        else if (t2 == null) return t1;
        dfs(t1, t2);
        return t1;
    }

    private void dfs (TreeNode t1, TreeNode t2) {

        if (t2.left != null) {
            if (t1.left == null) t1.left = new TreeNode(0);
            dfs(t1.left, t2.left);
        }

        if (t2.right != null) {
            if (t1.right == null) t1.right = new TreeNode(0);
            dfs(t1.right, t2.right);
        }

        t1.val = t1.val + t2.val;
    }
}
