package isEvenOddTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2021/12/25 上午7:56
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

public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int v = q.peek().val;
            for (int i = 0; i < n; i++) {
                TreeNode cur = q.poll();
                if ((level & 1) == 0) {
                    if ((cur.val & 1) == 0 || (i > 0 && cur.val <= v)) return false;
                }
                else {
                    if ((cur.val & 1) == 1 || (i > 0 && cur.val >= v)) return false;
                }
                v = cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            level++;
        }
        return true;
    }
}
