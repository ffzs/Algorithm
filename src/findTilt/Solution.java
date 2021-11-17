package findTilt;

/**
 * @author: ffzs
 * @Date: 2021/11/18 上午7:34
 *
 *
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
    int res = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs (TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        res += Math.abs(left - right);
        return left + right + node.val;
    }

}
