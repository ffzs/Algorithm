package numComponents;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/12 上午10:23
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public int numComponents(ListNode head, int[] nums) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n += 1;
            cur = cur.next;
        }
        boolean[] isIn = new boolean[n];
        for (int num : nums) {
            isIn[num] = true;
        }

        int res = 0, cnt = 0;
        cur = head;
        while (cur != null) {
            if (isIn[cur.val]) {
                cnt += 1;
            }
            else {
                if (cnt != 0) {
                    res += 1;
                    cnt = 0;
                }
            }
            cur = cur.next;
        }
        if (cnt > 0) res += 1;
        return res;
    }

}
