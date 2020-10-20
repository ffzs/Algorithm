package reorderList;

/**
 * @author: ffzs
 * @Date: 2020/10/20 上午6:55
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    ListNode left;
    public void reorderList(ListNode head) {
        left = head;
        reorder(head);
    }

    private void reorder (ListNode node) {
        if (node!=null && node.next != null) {
            reorder(node.next);
            if (left.next == null || left.next.next == null ) return;
            ListNode cur = node.next;
            node.next = null;
            cur.next = left.next;
            left.next = cur;
            left = cur.next;
        }
    }
}
