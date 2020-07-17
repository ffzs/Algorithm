package maxPathSum;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/21
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class Solution {

    private int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        nodeSum(root);
        return res;
    }

    private int nodeSum (TreeNode root) {
        if (root == null) return 0;

        int leftNode = nodeSum(root.left);
        int rightNode = nodeSum(root.right);
        int ret = Math.max(Math.max(leftNode, rightNode) + root.val, root.val);
        int max = Math.max(leftNode + rightNode + root.val, ret);
        res = Math.max(max, res);

        return ret;
    }
}
