package minCameraCover;

/**
 * @author: ffzs
 * @Date: 2020/9/22 上午7:05
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    int res = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        int val = dfs(root);
        return val == 0? res+1:res;
    }

    private int dfs (TreeNode root) {
        if (root.right == null && root.left == null) {
            return 0;
        }
        int right = -1, left = -1;
        if (root.left != null) {
            left = dfs(root.left);
        }
        if (root.right != null){
            right = dfs(root.right);
        }
        if (right==0 || left==0) {
            res++;
            return 2;
        }
        if (left == 2|| right == 2) {
            return 1;
        }
        return 0;
    }
}
