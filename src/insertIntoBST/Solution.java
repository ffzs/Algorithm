package insertIntoBST;

import java.util.function.DoubleToIntFunction;

/**
 * @author: ffzs
 * @Date: 2020/9/30 上午7:18
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
    boolean found = false;
    int val;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        this.val = val;
        dfs(root);
        if (root == null) {
            root = new TreeNode(val);
        }
        else if (!found) {
            TreeNode cur = root;
            while (cur.right != null) cur = cur.right;
            cur.right = new TreeNode(val);
        }
        return root;
    }

    private void dfs (TreeNode root) {
        if (!found && root != null) {

            dfs(root.left);
            if (!found && root.val > val) {
                System.out.println(root.val);
                if (root.left == null) {
                    root.left = new TreeNode(val);
                }
                else if (root.left.val > val) {
                    TreeNode cur = root.left;
                    root.left = new TreeNode(val);
                    root.left.right = cur;
                }
                else {
                    TreeNode cur = root.left;
                    while (cur.right != null) cur = cur.right;
                    cur.right = new TreeNode(val);
                }
                found = true;
            }
            dfs(root.right);
        }
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);
        Solution solution = new Solution();
        System.out.println(solution.insertIntoBST(root, 25));
    }
}
