package replaceValueInTree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2024/2/7 下午7:17
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

    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        root.val = 0;

        while (!queue.isEmpty()) {
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            int sum = 0;
            for (TreeNode fa : queue) {
                if (fa.left != null) {
                    queue1.offer(fa.left);
                    sum += fa.left.val;
                }

                if (fa.right != null) {
                    queue1.offer(fa.right);
                    sum += fa.right.val;
                }
            }

            for (TreeNode fa : queue) {
                int childSum = (fa.left != null ? fa.left.val : 0) +
                        (fa.right != null ? fa.right.val : 0);

                if (fa.left != null) {
                    fa.left.val = sum -childSum;
                }

                if (fa.right != null) {
                    fa.right.val = sum - childSum;
                }
            }
            queue = queue1;
        }
        return root;
    }

}
