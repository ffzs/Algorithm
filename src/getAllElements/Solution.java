package getAllElements;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/5/1 上午8:41
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
    List<Integer> res = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        helper(root1, true);
        helper(root2, false);
        res.addAll(queue);
        return res;
    }

    private void helper (TreeNode node, boolean isOne) {
        if (node == null) return;

        helper(node.left, isOne);

        if (isOne) {
            queue.offer(node.val);
        }
        else {
            while (!queue.isEmpty() && queue.peek() <= node.val) res.add(queue.poll());
            res.add(node.val);
        }

        helper(node.right, isOne);
    }

}
