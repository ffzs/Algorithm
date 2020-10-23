package isPalindrome3;

/**
 * @author: ffzs
 * @Date: 2020/10/23 上午9:59
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    ListNode pre;
    boolean res = true;
    public boolean isPalindrome(ListNode head) {
        pre = head;
        deal(head);
        return res;
    }

    private void deal (ListNode node) {
        if (node != null) {
            deal(node.next);
            if (res) {
                res = pre.val == node.val;
                pre = pre.next;
            }
        }
    }
}
