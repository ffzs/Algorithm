package sumNumbers;

/**
 * @author: ffzs
 * @Date: 2020/10/29 上午8:48
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return totalSum;
    }

    private void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            totalSum += sum*10 + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum*10 + node.val);
        }
        if (node.right != null) {
            dfs(node.right, sum*10 + node.val);
        }
    }
}
