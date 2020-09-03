package binaryTreePaths;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/9/4 上午7:28
 */
public class Solution {
    List<String> res  = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return  res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {

        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(sb.append(root.val).toString());
                return;
            }
            sb.append(root.val).append("->");
            if (root.left!=null) dfs(root.left, new StringBuilder(sb));
            if (root.right!=null) dfs(root.right, new StringBuilder(sb));
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
