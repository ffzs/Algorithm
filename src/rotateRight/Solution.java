package rotateRight;

/**
 * @author: ffzs
 * @Date: 2021/3/27 上午8:50
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        System.out.println(n);

        tail.next = head;

        for (int i = 0; i < (n-k%n); i++) {
            System.out.println(tail.val);
            tail = tail.next;

        }

        head = tail.next;
        tail.next = null;
        return head;
    }

}
