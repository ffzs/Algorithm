package maxLevelSum;

/**
 * @author: ffzs
 * @Date: 2022/7/31 下午12:46
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
    int[] cnt;
    int maxLevel = 1;
    public int maxLevelSum(TreeNode root) {
        cnt = new int[100];
        dfs(root, 1);
        int maxV = root.val, res = 1;
        for (int i = 1; i <= maxLevel; i++) {
            if (cnt[i] > maxV) {
                maxV = cnt[i];
                res = i;
            }
        }
        return res;
    }

    private void dfs (TreeNode node, int level) {
        if (node == null) return;
        maxLevel = Math.max(maxLevel, level);
        dfs(node.left, level + 1);
        cnt[level] += node.val;
        dfs(node.right, level + 1);
    }

}
