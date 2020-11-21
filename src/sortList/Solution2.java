package sortList;

/**
 * @author: ffzs
 * @Date: 2020/11/21 上午11:06
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int min = head.val, max = head.val;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (min > cur.val) min = cur.val;
            else max = Math.max(max, cur.val);
        }
        int[] counter = new int[max - min + 1];
        for (ListNode cur = head; cur != null; cur = cur.next) {
            counter[cur.val - min]++;
        }
        ListNode cur = head;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                for (int j = 0; j < counter[i]; j++) {
                    cur.val = i + min;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
