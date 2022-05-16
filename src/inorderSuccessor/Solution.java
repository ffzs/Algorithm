package inorderSuccessor;

/**
 * @author: ffzs
 * @Date: 2022/5/16 上午9:11
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    TreeNode res = null;
    boolean flag = false;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        find(root, p);
        return res;
    }

    private void find (TreeNode node, TreeNode p) {
        if (res != null || node == null) return;

        if (p.val <= node.val && node.left != null) find(node.left, p);
        if (node == p) flag = true;
        else if (flag) {
            res = node;
            flag = false;
            return;
        }

        if (p.val >= node.val && node.right != null) find(node.right, p);
    }

}
