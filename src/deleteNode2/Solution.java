package deleteNode2;

import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2022/6/2 上午9:04
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            TreeNode l = root.left;
            if (l != null) {
                TreeNode cur = l;
                while (cur.right != null) cur = cur.right;
                cur.right = root.right;
                return l;
            }
            return root.right;
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }

}
