package addOneRow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/8/5 上午9:15
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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }

        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (level < depth-1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            level += 1;
        }

        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                TreeNode node = new TreeNode(val);
                node.left = cur.left;
                cur.left = node;
            }
            else {
                cur.left = new TreeNode(val);
            }
            if (cur.right != null) {
                TreeNode node = new TreeNode(val);
                node.right = cur.right;
                cur.right = node;
            }
            else cur.right = new TreeNode(val);
        }

        return root;
    }
}
