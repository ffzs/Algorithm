package isSymmetric;

import java.util.ArrayList;

/**
 * @author ffzs
 * @describe
 * @date 2020/5/31
 */
public class Solution {
    ArrayList<Integer> left = new ArrayList<>();
    ArrayList<Integer> right = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        LTraversal(root.left);
        RTraversal(root.right);
        if (left.size()!=right.size()) return false;
        for (int i = 0; i < left.size(); i++) {
            Integer l = left.get(i);
            Integer r = right.get(i);
            if (l == null) {
                if (r != null) return false;
            } else {
                if (r != null && !l.equals(r)) return false;
            }
        }
        return true;
    }

    private void LTraversal (TreeNode root) {
        if (root != null) {
            left.add(root.val);
            LTraversal(root.left);
            LTraversal(root.right);
        }else{
            left.add(null);
        }
    }

    private void RTraversal (TreeNode root) {
        if (root != null) {
            right.add(root.val);
            RTraversal(root.right);
            RTraversal(root.left);
        }else{
            right.add(null);
        }
    }
}


class test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.isSymmetric(root));
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
