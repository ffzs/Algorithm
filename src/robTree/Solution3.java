package robTree;

/**
 * @author: ffzs
 * @Date: 2020/8/5 上午8:15
 */
public class Solution3 {

    public int rob(TreeNode root) {
        if (root == null) return 0;
        subRob(root);
        return root.val;
    }

    private void subRob (TreeNode root) {
        if (root.left!= null) subRob(root.left);
        if (root.right!= null) subRob(root.right);

        int s1 = 0, s2 = root.val;

        if(root.left!=null) {
            s1 += root.left.val;
            s2 += root.left.left != null ? root.left.left.val:0;
            s2 += root.left.right != null ? root.left.right.val:0;
        }


        if (root.right != null) {
            s1 += root.right.val;
            s2 += root.right.left != null ? root.right.left.val:0;
            s2 += root.right.right != null ? root.right.right.val:0;
        }

        root.val = Math.max(s1, s2);
    }
}
