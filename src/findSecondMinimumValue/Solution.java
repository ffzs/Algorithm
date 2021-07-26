package findSecondMinimumValue;

/**
 * @author: ffzs
 * @Date: 2021/7/27 上午7:09
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
    private int res = -1;
    private int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left == null) return;
        if (root.left.val == min) {
            if (root.right.val != min) {
                res = res == -1 ? root.right.val:Math.min(res, root.right.val);
            }
            dfs(root.left);
        }
        if (root.right.val == min) {
            if (root.left.val != min) res = res == -1 ? root.left.val:Math.min(res, root.left.val);
            dfs(root.right);
        }
    }
}
