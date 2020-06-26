package removeDuplicateNodes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        Set<Integer> valSet = new HashSet<>();
        valSet.add(tmp.val);
        while (tmp.next!= null) {
            if (valSet.contains(tmp.next.val)) {
                tmp.next = tmp.next.next ;
            }else{
                valSet.add(tmp.next.val);
                tmp = tmp.next;
            }
        }

        return head;
    }
}
