package connect;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2020/9/28 上午7:44
 */


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new LinkedList<>();
        root.next = null;
        queue.offer(root);
        Node pre = root,current;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                current = queue.poll();
                if (i == 0) {
                    pre = current;
                }
                else{
                    pre.next=current;
                    pre = current;
                }
                assert current != null;
                if (i == size-1) {
                    current.next = null;
                }
                System.out.println(current.val);
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return root;
    }
}
