package getMinimumDifference;

import com.sun.source.tree.Tree;

/**
 * @author: ffzs
 * @Date: 2020/10/12 上午6:23
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    int pre = -1, min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs (TreeNode root) {
        if (root != null) {
            dfs(root.left);

            if (pre>=0) min = Math.min(root.val - pre, min);
            pre = root.val;

            dfs(root.right);
        }
    }
}
