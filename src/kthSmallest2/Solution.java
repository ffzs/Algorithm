package kthSmallest2;

/**
 * @author: ffzs
 * @Date: 2021/10/17 上午7:01
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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node){
        if (node == null || k < 0) return 0;
        int left = dfs(node.left);
        k--;
        if (k == 0) return node.val;
        int right = dfs(node.right);
        return left + right;
    }

}
