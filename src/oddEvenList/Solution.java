package oddEvenList;

/**
 * @author: ffzs
 * @Date: 2020/11/13 下午9:58
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head, evenHead = head.next, head2 = head.next;
        while (evenHead.next != null) {
            oddHead.next = evenHead.next;
            oddHead = oddHead.next;
            oddHead.next = evenHead;
            evenHead = evenHead.next;
        }
        return head;
    }
}
