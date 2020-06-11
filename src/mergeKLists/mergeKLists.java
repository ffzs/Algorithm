package mergeKLists;

import java.util.ArrayList;

public class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int num = lists.length;
        if (num<1) return null;
        for (int i=0; i<lists.length; ++i) {
            ListNode start = new ListNode(-1);
            start.next = lists[i];
            lists[i] = start;
        }

        ListNode res = new ListNode(-1);
        ListNode t = res;
        int flag = 2;
        while (flag>1) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            flag=0;
            for (int i=0; i<num; ++i) {
                if (lists[i].next!=null) {
                    if (lists[i].next.val<min) {
                        min=lists[i].next.val;
                        index = i;
                    }
                    if (lists[i].next != null) {
                        flag++;
                    }
                }
            }
            t.next = new ListNode(min);
            t = t.next;
            lists[index].next = lists[index].next.next;
        }

        return res.next;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}