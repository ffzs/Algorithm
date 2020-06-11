package isValidBST;

public class isValidBST {
    long tmp = Long.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        if (root==null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= tmp) return false;
        tmp = root.val;
        return isValidBST(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
