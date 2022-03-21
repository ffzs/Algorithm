package findTarget;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/3/21 上午8:11
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
    Set<Integer> set = new HashSet<>();
    Boolean res = false;
    int k, first = -100000;
    public boolean findTarget(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs (TreeNode node) {
        if (node == null || res) return;
        dfs(node.left);
        if (node.val + first > k) return;
        if (set.contains(k - node.val)) {
            res = true;
            return;
        }
        if (first == -100000) first = node.val;
        set.add(node.val);
        dfs(node.right);
    }

}
