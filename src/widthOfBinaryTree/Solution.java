package widthOfBinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2022/8/27 下午12:46
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

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        root.val = 0;
        deque.offer(root);
        int res = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            res = Math.max(deque.getLast().val - deque.getFirst().val + 1, res);
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                int val = cur.val << 1;
                if (cur.left != null) {
                    cur.left.val = val;
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = val + 1;
                    deque.offer(cur.right);
                }
            }
        }
        return res;
    }

}
