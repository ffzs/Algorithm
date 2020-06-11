package isSubtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class isSubtree {
    public static boolean isSubtree (TreeNode s, TreeNode t) {
        if (s==null) return false;
        else return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
    }

    static boolean isSameTree (TreeNode n1, TreeNode n2) {
        if (n1==null && n2==null) return true;
        else if (n1 == null || n2 == null) return false;
        return n1.val==n2.val && isSameTree(n1.left, n2.left) && isSameTree(n1.right, n2.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}
