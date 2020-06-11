package mergeTwoLists;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class mergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1);
        ListNode tmp=head;
        while(l1.next!=null&&l2.next!=null){
            if (l1.val<l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1.next==null?l2.next:l1.next;
        return head.next;
    }
}


