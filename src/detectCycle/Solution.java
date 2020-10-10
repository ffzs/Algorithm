package detectCycle;

/**
 * @author: ffzs
 * @Date: 2020/10/10 上午8:20
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null ) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }

        if (fast.next == null || fast.next.next == null) return null;
        slow = head;
        while (fast!= slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(3);
        ListNode cross = new ListNode(2);
        head.next = cross;
        cross.next = new ListNode(0);
        cross.next.next = new ListNode(-4);
        cross.next.next.next = cross;
        System.out.println(solution.detectCycle(head));
    }
}
