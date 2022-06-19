package findFrequentTreeSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/6/19 上午8:48
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

    Map<Integer, Integer> map = new HashMap<>();
    int maxVal = Integer.MIN_VALUE, cnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int[] res = new int[cnt];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) res[i++] = entry.getKey();
        }
        return res;
    }

    private int dfs (TreeNode node) {
        if (node == null) return 0;

        int ret = dfs(node.left) + dfs(node.right) + node.val;
        map.put(ret, map.getOrDefault(ret, 0) + 1);
        if (map.get(ret) > maxVal) {
            maxVal = map.get(ret);
            cnt = 1;
        }
        else if (map.get(ret) == maxVal) cnt += 1;
        return ret;
    }

}
