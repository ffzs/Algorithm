package mergeInBetween;

/**
 * @author: ffzs
 * @Date: 2023/1/30 上午8:14
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        for (int i = 0; i < a - 1; ++i) list1 = list1.next;
        ListNode pre = list1;
        for (int i = 0; i < b-a+1; ++i) list1 = list1.next;
        ListNode suf = list1.next;
        list1.next = null;
        pre.next = list2;
        while (list2.next != null) list2 = list2.next;
        list2.next = suf;
        return head;
    }

}
