package pruneTree;

/**
 * @author: ffzs
 * @Date: 2022/7/21 上午11:59
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

    public TreeNode pruneTree(TreeNode root) {
        if (prune(root)) return root;
        else return null;
    }

    private boolean prune (TreeNode node) {
        if (node == null) return false;

        boolean left = prune(node.left);
        if (!left) node.left = null;
        boolean right = prune(node.right);
        if (!right) node.right = null;

        return node.val == 1 || left || right;
    }

}
