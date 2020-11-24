package countNodes;

/**
 * @author: ffzs
 * @Date: 2020/11/24 上午7:44
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int max = 0, res = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode tmp = root;
        while (tmp != null) {
            max++;
            tmp = tmp.left;
        }
        System.out.println(max);
        dfs(root, 1);
        for (int i = 0; i < max-1; i++) {
            res += Math.pow(2, i);
        }
        return res;
    }

    private void dfs (TreeNode root, int level) {
        if (level == max) res++;
        if(root.left!=null) dfs(root.left, level+1);
        if(root.right!=null) dfs(root.right, level+1);
    }
}
