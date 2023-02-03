package btreeGameWinningMove;

/**
 * @author: ffzs
 * @Date: 2023/2/3 下午5:49
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
    int left, right, x;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.x = x;
        dfs(root);
        return Math.max(Math.max(left, right), n - 1 - left - right) * 2 > n;
    }

    public int dfs (TreeNode node) {
        if (node == null) return 0;
        int l = dfs(node.left);
        int r = dfs(node.right);
        if (node.val == x) {
            left = l;
            right = r;
        }

        return l + r + 1;
    }

}
