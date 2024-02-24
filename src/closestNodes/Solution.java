package closestNodes;

import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/2/24 下午12:48
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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> vals = new ArrayList<>();
        dfs(root, vals);
        for (int query : queries) {
            int max = -1;
            int min = -1;
            int idx = biSearch(vals, query);
            if (idx < vals.size()) {
                max = vals.get(idx);
                if (vals.get(idx) == query) {
                    min = query;
                    res.add(List.of(min, max));
                    continue;
                }
            }
            if (idx > 0) {
                min = vals.get(idx - 1);
            }
            res.add(List.of(min, max));
        }
        return res;
    }

    private void dfs (TreeNode node, List<Integer> vals) {
        if (node == null) return;

        dfs(node.left, vals);
        vals.add(node.val);
        dfs(node.right, vals);
    }

    private int biSearch (List<Integer> vals, int target) {
        int l = 0, r = vals.size();

        while (l < r) {
            int mid = (l + r) >> 1;
            if (vals.get(mid) >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }

}
