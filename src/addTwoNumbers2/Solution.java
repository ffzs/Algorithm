package addTwoNumbers2;

/**
 * @author: ffzs
 * @Date: 2020/10/4 上午8:37
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1==null?0:l1.val) + (l2==null?0:l2.val) +carry;
            if (cur.val==-1) {
                cur.val = sum%10;
            }else{
                cur.next = new ListNode(sum%10);
                cur = cur.next;
            }
            carry = sum / 10;
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
        }
        return res;
    }
}
