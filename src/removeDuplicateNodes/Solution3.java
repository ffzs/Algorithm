package removeDuplicateNodes;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */
public class Solution3 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode t = tmp;
            while (t.next != null) {
                if (t.next.val == tmp.val) {
                    t.next = t.next.next;
                }
                else {
                    t = t.next;
                }
            }
            tmp = tmp.next;
        }
        return head;
    }
}
