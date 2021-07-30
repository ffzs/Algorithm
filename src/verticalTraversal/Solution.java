package verticalTraversal;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/7/31 上午6:52
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    Map<Integer, Map<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cols = getSortKey(map.keySet());
        for (int col : cols) {
            List<Integer> lst = new ArrayList<>();
            var subMap = map.get(col);
            var rows = getSortKey(subMap.keySet());
            for (int row : rows) {
                var tmp = subMap.get(row);
                tmp.sort(Comparator.naturalOrder());
                lst.addAll(tmp);
            }
            res.add(lst);
        }
        return res;
    }

    private List<Integer> getSortKey(Set<Integer> keySet){
        List<Integer> keys = new ArrayList<>(keySet);
        keys.sort(Comparator.naturalOrder());
        return keys;
    }

    private void dfs(TreeNode node, int col, int row) {
        if (node == null) return;

        Map<Integer, List<Integer>> subMap = map.getOrDefault(col, new HashMap<>());
        if (!subMap.containsKey(row)) subMap.put(row, new ArrayList<>());
        subMap.get(row).add(node.val);
        map.put(col, subMap);
        dfs(node.left, col - 1, row + 1);
        dfs(node.right, col + 1, row + 1);
    }
}
