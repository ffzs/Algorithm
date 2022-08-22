package printTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/8/22 上午8:41
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

    private int maxDepth = 1;
    public List<List<String>> printTree(TreeNode root) {
        getDepth(root, 1);
        int n = (1 << maxDepth) - 1;
        List<List<String>> res = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tmp.add("");
        }
        for (int i = 0; i < maxDepth; i++) {
            res.add(new ArrayList<>(tmp));
        }
        dfs(root, res, 0, n - 1, 0);
        return res;
    }

    private void dfs (TreeNode node, List<List<String>> lst, int l, int r, int depth) {
        if (node == null || l > r) return;
        if (l == r) {
            lst.get(depth).set(l, String.valueOf(node.val));
            return;
        }

        int mid = (l + r) >>> 1;
        lst.get(depth).set(mid, String.valueOf(node.val));
        dfs(node.left, lst, l, mid-1, depth + 1);
        dfs(node.right, lst, mid + 1, r, depth + 1);
    }

    private void getDepth(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > maxDepth) maxDepth = depth;

        getDepth(node.left, depth + 1);
        getDepth(node.right, depth + 1);
    }

}
