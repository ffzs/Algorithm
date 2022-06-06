package MyCalendarThree;

import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/6/6 上午8:40
 */
public class MyCalendarThree {

    class Node {
        int l, r, v, lazy;
        Node left, right;
        Node (int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    private Node root;
    public MyCalendarThree() {
        this.root = new Node(0, (int) 1e9);
    }

    public int book(int start, int end) {
        update(root, start, end-1, 1);
        return root.v;
    }

    public void update (Node node, int l, int r, int v) {
        if (node.l > r || node.r < l) return;

        if (node.l >= l && node.r <= r) {
            node.v += v;
            node.lazy += v;
        }
        else {
            create(node);
            pushDown(node);
            update(node.left, l, r, v);
            update(node.right, l, r, v);
            pushUp(node);
        }
    }

    private void create(Node node) {
        int mid = (node.l + node.r) >> 1;
        if (node.left == null) node.left = new Node(node.l, mid);
        if (node.right == null) node.right = new Node(mid + 1, node.r);
    }

    private void pushDown (Node node) {
        if (node.lazy > 0) {
            node.left.v += node.lazy;
            node.left.lazy += node.lazy;
            node.right.v += node.lazy;
            node.right.lazy += node.lazy;
            node.lazy = 0;
        }
    }

    private void pushUp (Node node) {
        node.v = Math.max(node.left.v , node.right.v);
    }
}
