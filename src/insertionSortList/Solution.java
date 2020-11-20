package insertionSortList;

/**
 * @author: ffzs
 * @Date: 2020/11/20 上午11:28
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        while (head.next != null) {
            if (head.next.val < head.val) {
                ListNode next = head.next;
                head.next = next.next;
                insert(root, next);
            }
            else head = head.next;
        }
        return root.next;
    }

    private void insert (ListNode head, ListNode cur) {
        while (head.next != null && head.next.val < cur.val) {
            head = head.next;
        }
        cur.next = head.next;
        head.next = cur;
    }
}
