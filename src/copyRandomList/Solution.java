package copyRandomList;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/7/22 上午6:50
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        List<Integer> lst = new ArrayList<>();
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            lst.add(tmp.val);
            tmp.val = i++;
            tmp = tmp.next;
        }

        Node res = new Node(lst.get(0));
        List<Node> nodes = new ArrayList<>();
        Node cur = res;
        nodes.add(res);
        for (int j = 1; j < lst.size(); j++) {
            cur.next = new Node(lst.get(j));
            cur = cur.next;
            nodes.add(cur);
        }
        nodes.add(null);

        cur = res;
        while (head != null) {
            Node random = head.random;
            if (random != null) {
                cur.random = nodes.get(random.val);
            }
            cur = cur.next;
            head = head.next;
        }

        return res;
    }

}
