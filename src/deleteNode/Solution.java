package deleteNode;

/**
 * @author: ffzs
 * @Date: 2021/11/2 上午7:22
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

}
