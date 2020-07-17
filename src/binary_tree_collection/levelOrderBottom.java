package binary_tree_collection;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/5
 */
public class levelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            // 奇数层对数组进行翻转
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}
