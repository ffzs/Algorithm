package deepestLeavesSum;

/**
 * @author: ffzs
 * @Date: 2022/8/17 上午9:22
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

    int maxDepth = 0, sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs (TreeNode node, int depth) {
        if (node == null) return;
        dfs(node.left, depth + 1);
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = 0;
        }
        if (depth == maxDepth) sum += node.val;
        dfs(node.right, depth + 1);
    }

}
