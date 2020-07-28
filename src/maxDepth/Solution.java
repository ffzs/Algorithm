package maxDepth;

/**
 * @author: ffzs
 * @Date: 2020/7/28 上午8:26
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }


    public int maxDepth(TreeNode root, int level) {
        if (root == null) return level;
        int right = maxDepth(root.right, level+1);
        int left = maxDepth(root.left, level+1);
        return Math.max(right, left);
    }
}
