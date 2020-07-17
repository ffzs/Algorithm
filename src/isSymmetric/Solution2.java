package isSymmetric;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/31
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return doubleTraversal(root.left, root.right);
    }

    private boolean doubleTraversal (TreeNode left, TreeNode right) {
        if (left == right) return true;
        if (left != null && right != null) {
            return left.val == right.val && doubleTraversal(left.left, right.right) && doubleTraversal(left.right, right.left);
        }else{
            return false;
        }
    }
}
