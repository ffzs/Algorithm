package largestValues;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/6/24 下午3:09
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

    List<Integer> res;
    public List<Integer> largestValues(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 1);
        return res;
    }

    private void dfs (TreeNode node, int depth) {
        if (node == null) return;

        update(node.val, depth);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    private void update(int val, int depth) {
        if (depth > res.size()) {
            for (int i = res.size(); i < depth; i++) {
                res.add(Integer.MIN_VALUE);
            }
        }
        if (val > res.get(depth-1)) res.set(depth-1, val);
    }
}
