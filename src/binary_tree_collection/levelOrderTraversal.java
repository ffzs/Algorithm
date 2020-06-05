package binary_tree_collection;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author ffzs
 * @describe 102. 二叉树的层序遍历
 * @date 2020/6/5
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class levelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);

        while (!queue.isEmpty()) {
            // 获取本层节点个数
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            // 通过循环将本层节点全部取出
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                //添加下层节点
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
