package connect2;

/**
 * @author: ffzs
 * @Date: 2020/10/15 上午8:36
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
        dfs(root);
        return root;
    }

    private void dfs (Node root) {
        if (root.left != null && root.right != null){
            Node cur = root.right;
            root.left.next = root.right;

            cur.next = root.next == null? null : root.next.left;
            dfs(root.right);
            dfs(root.left);
        }
    }
}
