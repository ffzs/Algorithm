package postorderTraversal;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/9/29 上午7:47
 */
public class Solution2 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(0,cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return res;
    }
}
