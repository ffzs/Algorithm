package sortedListToBST;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2020/8/18 上午8:39
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


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

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = new TreeNode(head.val);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ListNode cur = head.next;
        marker: while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (cur != null) {
                    assert tn != null;
                    tn.left = new TreeNode(cur.val);
                    queue.add(tn.left);
                    cur = cur.next;
                }
                else break marker;
                if (cur != null) {
                    tn.right = new TreeNode(cur.val);
                    queue.add(tn.right);
                    cur = cur.next;
                }
            }
        }
        node = head;
        sortedListToBST(root);
        return root;
    }

    private void sortedListToBST (TreeNode root) {
        if (root != null) {
            sortedListToBST(root.left);
            root.val = node.val;
            node = node.next;
            sortedListToBST(root.right);
        }
    }
}
