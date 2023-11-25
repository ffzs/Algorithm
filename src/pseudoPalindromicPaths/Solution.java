package pseudoPalindromicPaths;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/11/25 上午8:49
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
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs (TreeNode node , int v) {
        if (node == null) return;
        v ^= (1<<node.val);
        if (node.left == null && node.right == null) {
            if ((v & (v - 1)) == 0) res ++;
            return;
        }

        dfs(node.left, v);
        dfs(node.right, v);
    }

}
