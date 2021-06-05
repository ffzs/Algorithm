package removeElements;

/**
 * @author: ffzs
 * @Date: 2021/6/5 上午9:05
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        while (head != null) {
            if (head.val == val) {
                pre.next=head.next;
            }
            else pre = pre.next;
            head = head.next;
        }
        return root.next;
    }

}
