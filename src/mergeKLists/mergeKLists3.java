package mergeKLists;

public class mergeKLists3 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len==0) return null;
        return split(lists,0,len-1);
    }

    private ListNode split(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }else if(end-start==1){
            return merge2Lists(lists[start], lists[end]);
        }else if (end-start>1){
            int mid = (end+start)>>1;
            ListNode left = split(lists, start, mid);
            ListNode right = split(lists, mid+1, end);
            return merge2Lists(left, right);
        }
        return null;
    }

    private ListNode merge2Lists(ListNode n1, ListNode n2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;

        while (n1!=null&&n2!=null){
            if (n1.val >= n2.val) {
                tmp.next = n2;
                n2 = n2.next;
            }else{
                tmp.next = n1;
                n1 = n1.next;
            }
            tmp=tmp.next;
        }
        tmp.next = n1 != null?n1:n2;
        return head.next;
    }
}
