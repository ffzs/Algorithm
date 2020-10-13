package swapPairs;

/**
 * @author: ffzs
 * @Date: 2020/10/13 上午7:15
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;

        ListNode n1, n2, cur = head, pre = null;

        while (cur != null && cur.next != null) {
            n1 = cur;
            n2 = n1.next;
            cur = n2.next;
            if (pre != null) pre.next = n2;
            n2.next = n1;
            n1.next = cur;
            pre = n1;
        }

        return res;
    }
}
