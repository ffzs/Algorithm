package binary_tree_collection;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/5
 */


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class treeToDoublyList {
    Node tail, head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }
    private void dfs(Node node) {
        if (node == null) return;
        dfs(node.left);
        if (tail != null) {
            tail.right = node;
            node.left = tail;
        }else{
            head = node;
        }
        tail = node;
        dfs(node.right);
    }
}
