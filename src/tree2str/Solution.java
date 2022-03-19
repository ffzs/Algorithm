package tree2str;

/**
 * @author: ffzs
 * @Date: 2022/3/19 上午8:07
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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        sub(root);
        return sb.toString();
    }

    private void sub (TreeNode node) {
        if (node == null) return;
        sb.append(node.val);
        if (node.left == null && node.right == null) return;
        sb.append('(');
        if (node.left != null) sub(node.left);
        sb.append(')');
        if (node.right != null) {
            sb.append('(');
            sub(node.right);
            sb.append(')');
        }
    }
}
