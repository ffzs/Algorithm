package convertBST;

/**
 * @author: ffzs
 * @Date: 2020/9/21 上午7:06
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        greater(root);
        return root;
    }

    private void greater (TreeNode root) {
        if (root != null) {
            greater(root.right);
            sum += root.val;
            root.val = sum;
            greater(root.left);
        }
    }
}
