package zigzagLevelOrder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/12/22 下午7:54
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int num = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode cur = deque.pop();
                System.out.println(cur.val);
                if ((level&1) == 0) list.add(cur.val);
                else list.add(0, cur.val);
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
