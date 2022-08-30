package insertIntoMaxTree;

/**
 * @author: ffzs
 * @Date: 2022/8/30 上午9:35
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

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null || root.val < val) {
            node.left = root;
            return node;
        }

        TreeNode cur = root;
        while (true) {
            if (cur.right == null) {
                cur.right = node;
                return root;
            }

            if (cur.right.val < val) {
                node.left = cur.right;
                cur.right = node;
                return root;
            }
            cur = cur.right;
        }
    }

}
