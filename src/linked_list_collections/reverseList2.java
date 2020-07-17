package linked_list_collections;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/6
 */
public class reverseList2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}
