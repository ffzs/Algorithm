package reverseOddLevels;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/15 上午11:06
 */
public class Solution2 {

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        dfs(root.left, root.right, 1);
        return root;
    }

    private void dfs (TreeNode l, TreeNode r, int level) {
        if (l == null) return;
        if (level % 2 == 1) {
            int t = l.val;
            l.val = r.val;
            r.val = t;
        }

        dfs(l.left, r.right, level + 1);
        dfs(l.right, r.left, level + 1);
    }

}
