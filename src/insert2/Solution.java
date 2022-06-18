package insert2;

/**
 * @author: ffzs
 * @Date: 2022/6/18 上午8:46
 */

class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}

public class Solution {

    public Node insert(Node head, int insertVal) {
        Node it = new Node(insertVal);
        if (head == null) {
            it.next = it;
            return it;
        }

        Node cur = head;
        while ((cur.val > insertVal || cur.next.val < insertVal)) {
            cur = cur.next;
            if (cur == head){
                while (cur.val <= cur.next.val && cur.next != head) cur = cur.next;
                break;
            }
        }

        it.next = cur.next;
        cur.next = it;
        return head;
    }

}
