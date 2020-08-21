package minDepth;

/**
 * @author: ffzs
 * @Date: 2020/8/21 上午8:07
 */
public class Solution2 {

    public int minDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs (TreeNode root, int level) {
        if (root == null) return level -1;

        int left = dfs(root.left, level+1);
        int right = dfs(root.right, level+1);

        int min = Math.min(left, right);
        return min == level?Math.max(left, right):min;
    }
}
