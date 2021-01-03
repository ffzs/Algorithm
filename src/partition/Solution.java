package partition;

/**
 * @author: ffzs
 * @Date: 2021/1/3 上午10:18
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1Head = new ListNode(-1);
        ListNode l1tail = l1Head;
        ListNode l2Head = new ListNode(-1);
        ListNode l2tail = l2Head;
        while (head != null) {
            if (head.val < x) {
                l1tail.next = new ListNode(head.val);
                l1tail = l1tail.next;
            }
            else {
                l2tail.next = new ListNode(head.val);
                l2tail = l2tail.next;
            }
            head = head.next;
        }
        l1tail.next = l2Head.next;
        return l1Head.next;
    }
}
