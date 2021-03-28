package BSTIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2021/3/28 上午9:30
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

public class BSTIterator {
    List<Integer> list = new ArrayList<>();
    private Iterator<Integer> iter;
    public BSTIterator(TreeNode root) {
        dfs(root);
        System.out.println(list);
        iter = list.iterator();
    }

    private void dfs (TreeNode root) {
        if (root != null) {
            dfs(root.left);
            list.add(root.val);
            dfs(root.right);
        }
    }

    public int next() {
        return iter.next();
    }

    public boolean hasNext() {
        return iter.hasNext();
    }

}
