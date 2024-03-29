package rangeSumBST;

/**
 * @author: ffzs
 * @Date: 2021/4/27 下午2:42
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        else if (root.val <= high && root.val >= low) return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        else if (root.val < low) return rangeSumBST(root.right, low, high);
        else return rangeSumBST(root.left, low, high);
    }

}
