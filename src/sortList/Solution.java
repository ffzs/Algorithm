package sortList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/11/21 上午10:51
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        int[] tmp = new int[n];
        int i = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            tmp[i++] = cur.val;
        }
        Arrays.sort(tmp);
        i = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = tmp[i++];
        }
        return head;
    }
}
