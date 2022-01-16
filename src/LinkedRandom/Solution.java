package LinkedRandom;

import java.util.Random;

/**
 * @author: ffzs
 * @Date: 2022/1/16 上午8:14
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    ListNode root;
    Random r;
    public Solution(ListNode head) {
        root = head;
        r = new Random(2022);
    }

    public int getRandom() {
        int ret = 0, i = 1;
        for (ListNode cur = root; cur != null; cur = cur.next) {
            if (r.nextInt(i) == 0) ret = cur.val;
            ++i;
        }
        return ret;
    }
}
