package CBTInserter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/7/25 上午11:52
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

public class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();

        queue.offer(root);
        TreeNode cur;
        mark: while (true) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.peek();
                if (cur.right == null) {
                    if (cur.left != null) queue.offer(cur.left);
                    break mark;
                }
                queue.poll();
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
    }

    public int insert(int val) {
        TreeNode father = queue.peek();
        if (father.left == null) {
            father.left = new TreeNode(val);
            queue.offer(father.left);
            return father.val;
        }

        father.right = new TreeNode(val);
        queue.poll();
        queue.offer(father.right);
        return father.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
