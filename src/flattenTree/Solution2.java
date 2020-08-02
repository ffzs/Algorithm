package flattenTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/2 上午10:23
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root != null) {

            flatten(root.left);
            flatten(root.right);

            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;

            while (root.right != null)  root = root.right;

            root.right = tmp;
        }
    }
}
