package robTree;

import java.util.HashMap;

/**
 * @author: ffzs
 * @Date: 2020/8/5 上午7:58
 */
public class Solution2 {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        int left = 0, right = 0;
        if (root.left != null) left = rob(root.left.left) + rob(root.left.right);
        if (root.right != null) right = rob(root.right.left) + rob(root.right.right);
        int ret = Math.max(root.val+left+right, rob(root.left) + rob(root.right));
        map.put(root, ret);
        return ret;
    }
}
