package recoverTree;

/**
 * @author: ffzs
 * @Date: 2020/8/8 上午8:59
 */
public class Solution2 {

    TreeNode wrong1 = null;
    TreeNode wrong2 = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
        sortTree(root);

        int tmp = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = tmp;
    }

    private void sortTree (TreeNode root) {
        if (root != null) {
            sortTree(root.left);

            if (preNode == null) preNode = root;
            if (wrong1 == null && root.val < preNode.val) wrong1 = preNode;
            if (wrong1 != null && root.val < preNode.val) wrong2 = root;
            preNode = root;

            sortTree(root.right);
        }
    }
}