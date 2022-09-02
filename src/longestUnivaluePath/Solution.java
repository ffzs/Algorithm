package longestUnivaluePath;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/9/2 上午8:46
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
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;
    }

    private int dfs (TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int l = 0, r = 0;
        if (node.left != null && node.left.val == node.val) l += left + 1;
        if (node.right != null && node.right.val == node.val) r += right + 1;
        res = Math.max(res, l + r);
        return Math.max(l, r);
    }
}
