package mergeKLists;

import java.util.PriorityQueue;

public class mergeKLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2)->n1.val-n2.val);
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        for(ListNode n:lists){
            if (n!=null) pq.add(n);
        }

        while (!pq.isEmpty()) {
            tmp.next = pq.poll();
            tmp = tmp.next;
            if (tmp.next!=null) pq.add(tmp.next);
        }

        return head.next;
    }
}
