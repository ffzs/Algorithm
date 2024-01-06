package insertGreatestCommonDivisors;

/**
 * @author: ffzs
 * @Date: 2024/1/6 上午8:33
 */



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    ListNode tail = null;
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        dfs(head);
        return head;
    }

    private void dfs (ListNode node) {
        if (node == null) return;

        dfs(node.next);

        if (tail == null) {
            tail = node;
            return;
        }

        ListNode newNode = new ListNode(gcd(node.val, tail.val));
        newNode.next = tail;
        node.next = newNode;
        tail = node;
    }

    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

}
