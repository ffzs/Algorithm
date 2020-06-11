package rightSideView;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> result = new ArrayList<>();
    public static List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    static void dfs(TreeNode node, int depth) {
        if (depth == result.size()) result.add(node.val);
        if (node.right != null) dfs(node.right, depth+1);
        if (node.left != null) dfs(node.left, depth+1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
