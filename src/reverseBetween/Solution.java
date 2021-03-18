package reverseBetween;


/**
 * @author: ffzs
 * @Date: 2021/3/18 上午7:58
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left < 1) return head;
        ListNode root = new ListNode(-1, head);
        ListNode pre = root, l, r, tmp, tail;
        int i = 0;
        while (i < left - 1) {
            pre = pre.next;
            i++;
        }

        l = pre.next;
        tail = l;
        pre.next = null;
        r = l.next;
        l.next = null;


        while (r != null && i < right-1) {
            tmp = r;
            r = r.next;
            tmp.next = l;
            l = tmp;
            i++;
        }

        pre.next = l;
        tail.next = r;
        return root.next;
    }

}
