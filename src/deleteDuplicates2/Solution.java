package deleteDuplicates2;

/**
 * @author: ffzs
 * @Date: 2021/3/26 上午9:53
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null) {
            while (pre.next != null && pre.val == pre.next.val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }

        return head;
    }

}


