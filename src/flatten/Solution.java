package flatten;

/**
 * @author: ffzs
 * @Date: 2021/9/24 上午6:44
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

public class Solution {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs (Node node) {
        Node cur = node;
        Node last = null;

        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node childLast = dfs(cur.child);

                next = cur.next;

                cur.next = cur.child;
                cur.next.prev = cur;

                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child = null;
                last = childLast;
            }
            else last = cur;
            cur = next;
        }
        return last;
    }

}
