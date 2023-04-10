package nextLargerNodes;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * @author: ffzs
 * @Date: 2023/4/10 上午8:35
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n ++;
            cur = cur.next;
        }

        int[] arr = new int[n];
        cur = head;
        int i = 0;
        while (cur != null) {
            arr[i++] = cur.val;
            cur = cur.next;
        }

        int[] idx = new int[n];
        idx[n-1] = n-1;
        int[] res = new int[n];
        int max = arr[n-1];
        for (i = n-2; i >= 0; i--) {
            if (arr[i] >= max) {
                res[i] = 0;
                max = arr[i];
                idx[i] = i;
                continue;
            }

            if (arr[i] < arr[i+1]) {
                res[i] = arr[i+1];
                idx[i] = i + 1;
            }
            else if (arr[i] == arr[i + 1]) {
                res[i] = res[i + 1];
                idx[i] = idx[i + 1];
            }
            else {
                int j = i + 1;
                while (arr[i] >= arr[j]) {
                    j = idx[j];
                }
                res[i] = arr[j];
                idx[i] = j;
            }
        }
        return  res;
    }

}
