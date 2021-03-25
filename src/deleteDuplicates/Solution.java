package deleteDuplicates;

/**
 * @author: ffzs
 * @Date: 2021/3/25 上午9:03
 */



public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1, head);
        ListNode pre = root;
        boolean in = false;
        while (pre.next != null) {
            ListNode next = pre.next;
            while (next.next != null && next.val == next.next.val) {
                next = next.next;
                in = true;
            }
            if (in) {
                pre.next = next.next;
                in = false;
            }
            else pre = pre.next;
        }

        return root.next;
    }


}
