package minDepth;

import com.sun.source.tree.Tree;

/**
 * @author: ffzs
 * @Date: 2020/8/21 上午7:43
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {

        return dfs(root, 1);
    }

    public int dfs (TreeNode root, int level) {
        if (root == null) return level-1;
        if (root.left == null && root.right == null)
            return level;
        else if (root.left == null)
            return dfs(root.right, level+1);
        else if (root.right == null)
            return dfs(root.left, level+1);
        else
            return Math.min(dfs(root.left, level+1), dfs(root.right, level+1));
    }
}
