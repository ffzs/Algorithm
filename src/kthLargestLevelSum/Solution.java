package kthLargestLevelSum;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2024/2/23 下午7:50
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

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> lst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long v = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                v += cur.val;
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }

            lst.add(v);
        }
        lst.sort(Comparator.reverseOrder());
        if (lst.size() < k) return -1;
        return lst.get(k-1);
    }
}
