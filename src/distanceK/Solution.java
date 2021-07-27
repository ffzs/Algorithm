package distanceK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/7/28 上午6:58
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    List<Integer> res;
    Map<Integer, TreeNode> map;
    int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        map = new HashMap<>();
        this.k = k;
        findParents(root);

        dfs(target, null, 0);
        return res;
    }

    private void dfs(TreeNode node, TreeNode pre, int level) {
        if (node == null) return;

        if (level == k) {
            res.add(node.val);
            return;
        }

        if (node.left != pre) dfs(node.left, node, level + 1);
        if (node.right != pre) dfs(node.right, node, level + 1);

        if (map.get(node.val) != pre) dfs(map.get(node.val), node, level+1);

    }

    private void findParents(TreeNode node) {
        if (node.left != null) {
            map.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            map.put(node.right.val, node);
            findParents(node.right);
        }
    }
}
