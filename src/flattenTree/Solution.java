package flattenTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/2 上午10:06
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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        for (int i = 1; i < list.size(); ++i) {
            TreeNode pre = list.get(i-1);
            pre.left = null;
            pre.right = list.get(i);
        }

    }

    private void flatten(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            list.add(root);
            flatten(root.left, list);
            flatten(root.right, list);
        }
    }
}
