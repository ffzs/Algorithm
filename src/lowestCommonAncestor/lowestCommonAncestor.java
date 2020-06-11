package lowestCommonAncestor;

import java.util.Queue;

public class lowestCommonAncestor {
    public static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null && left == null) return null;
        else if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}