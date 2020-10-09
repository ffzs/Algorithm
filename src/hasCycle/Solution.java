package hasCycle;

/**
 * @author: ffzs
 * @Date: 2020/10/9 上午8:19
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next!=null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick.val == slow.val) return true;
        }
        return false;
    }
}
