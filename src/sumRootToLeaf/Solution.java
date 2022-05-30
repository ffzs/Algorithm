package sumRootToLeaf;

/**
 * @author: ffzs
 * @Date: 2022/5/30 上午8:58
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
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs (TreeNode node, int val) {
        if (node == null) return;
        int cur = (val << 1) | node.val;
        if (node.left == null && node.right == null) {
            res += cur;
            return;
        }

        if (node.left != null) dfs(node.left, cur);
        if (node.right != null) dfs(node.right, cur);
    }

}
