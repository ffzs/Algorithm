package removeDuplicateNodes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */
public class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        boolean[] valList = new boolean[20001];
        valList[head.val] = true;
        while (tmp.next!= null) {
            if (valList[tmp.next.val]) {
                tmp.next = tmp.next.next ;
            }else{
                valList[tmp.next.val] = true;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
