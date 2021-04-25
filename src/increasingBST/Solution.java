package increasingBST;

import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2021/4/25 上午10:05
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
    TreeNode node = null;
    TreeNode res = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs (TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (node == null) {
            node = root;
            res = node;
        }
        else {
            node.right = root;
            node.left = null;
            node = node.right;
        }

        dfs(root.right);
    }

}
