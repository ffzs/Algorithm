package splitListToParts;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/9/22 上午6:48
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tmp = head;
        ListNode[] res = new ListNode[k];
        int[] cnt = new int[k];
        int i = 0;
        while (tmp != null) {
            tmp = tmp.next;
            if (i >= k) i = 0;
            cnt[i++]++;
        }
        tmp = head;
        for (int j = 0; j < cnt.length; j++) {
            ListNode cur, next = null;
            if (cnt[j] == 0) {
                cur = null;
            }
            else {
                cur = new ListNode(tmp.val);
                next = cur;
                tmp = tmp.next;
            }
            for (int l = 1; l < cnt[j]; l++) {
                next.next = new ListNode(tmp.val);
                next = next.next;
                tmp = tmp.next;
            }
            res[j] = cur;
        }
        return res;
    }

}
