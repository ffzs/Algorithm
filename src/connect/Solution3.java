package connect;

/**
 * @author: ffzs
 * @Date: 2020/9/28 上午8:55
 */
public class Solution3 {

    public Node connect(Node root) {
        if (root == null) return null;
        dfs(root);
        return root;
    }

    private void dfs (Node root) {
        if (root.left == null && root.right == null) return;
        Node cur = root.right;
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        } else if (root.right == null) {
            cur = root.left;
        }

        Node rootNext = root.next;
        Node next = null;
        while (rootNext != null && next ==null) {
            if (rootNext.left != null || rootNext.right != null) {
                next = rootNext.left == null? rootNext.right : rootNext.left;
            }
            rootNext = rootNext.next;
        }



        cur.next = next;
        if (root.right != null) dfs(root.right);
        if (root.left != null) dfs(root.left);
    }
}
