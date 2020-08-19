package sortedListToBST;

/**
 * @author: ffzs
 * @Date: 2020/8/18 上午9:27
 */
public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;  // 通过设置pre对链表进行切割
        while(fast!= null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode node = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(node);
        return root;
    }
}