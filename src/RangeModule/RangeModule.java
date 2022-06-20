package RangeModule;

/**
 * @author: ffzs
 * @Date: 2022/6/20 下午3:34
 */

class Node {
    Node left, right;
    int used, add;
}

public class RangeModule {
    private final int END = (int) 1e9;
    private Node root;
    public RangeModule() {
        root = new Node();
    }

    public void addRange(int left, int right) {
        update(root, 1, END, left, right-1, 1);
    }

    private void update (Node node, int start, int end, int l, int r, int isUsed) {
        if (l <= start && r >= end) {
            node.add = isUsed;
            node.used = isUsed == 1 ? 1: 0;
            return;
        }

        int mid = (start + end) >> 1;
        pushDown(node);
        if (l <= mid) update(node.left, start, mid, l, r, isUsed);
        if (r > mid) update(node.right, mid + 1, end, l, r, isUsed);
        pushUp(node);
    }

    private void pushUp(Node node) {
        node.used = node.left.used & node.right.used;
    }

    private void pushDown(Node node) {
        if (node.left == null) node.left = new Node();
        if (node.right == null) node.right = new Node();
        if (node.add == 0) return;
        node.left.used = node.add == 1?1:0;
        node.right.used = node.add == 1 ? 1:0;
        node.left.add = node.add;
        node.right.add = node.add;
        node.add = 0;
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, END, left, right-1) == 1;
    }

    private int query (Node node, int start, int end, int l, int r) {
        if (l <= start && r >= end) return node.used;
        int mid = (start + end) >> 1;
        pushDown(node);
        int ret = 1;
        if (l <= mid) ret = ret & query(node.left, start, mid, l, r);
        if (r > mid) ret = ret & query(node.right, mid + 1, end, l, r);
        return ret;
    }

    public void removeRange(int left, int right) {
        update(root, 1, END, left, right-1, -1);
    }

}
