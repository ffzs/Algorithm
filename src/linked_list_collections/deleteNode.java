package linked_list_collections;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/6
 */
public class deleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, suf = head.next;
        while (suf != null && suf.val != val) {
            pre = suf;
            suf = suf.next;
        }
        if (suf != null) pre.next = suf.next;
        return head;
    }
}
