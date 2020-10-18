package removeNthFromEnd;

/**
 * @author: ffzs
 * @Date: 2020/10/18 上午9:18
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        this.n = n;
        remove(head);

        return this.n == 0 ? head.next: head;
    }

    private void remove (ListNode node) {
        if (node != null) {
            remove(node.next);

            if (n-- == 0) {
                node.next = node.next.next;
            }
        }
    }
}
