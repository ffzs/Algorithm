package isCousins;

import com.sun.source.tree.BreakTree;

/**
 * @author: ffzs
 * @Date: 2021/5/17 上午8:08
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

    int[] l1 = {-1,-1}, l2 = {-1,-1};

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0);
        return l1[1] == l2[1] && l1[0] != l2[0];
    }

    private void dfs(TreeNode root, int x, int y, int l) {
        if (l1[1] == -1 || l2[1] == -1) {
            if (root.left != null) {
                if (root.left.val == x) {
                    l1[0] = root.val;
                    l1[1] = l + 1;
                } else if (root.left.val == y) {
                    l2[0] = root.val;
                    l2[1] = l + 1;
                }
                dfs(root.left, x, y, l + 1);
            }
            if (root.right != null) {
                if (root.right.val == x) {
                    l1[0] = root.val;
                    l1[1] = l + 1;
                } else if (root.right.val == y) {
                    l2[0] = root.val;
                    l2[1] = l + 1;
                }
                dfs(root.right, x, y, l + 1);
            }
        }
    }
}


