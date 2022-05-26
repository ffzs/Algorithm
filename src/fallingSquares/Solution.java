package fallingSquares;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/5/26 上午9:05
 */

class Node {
    int l, r, h, mr;
    Node left, right;

    public Node(int l, int r, int h, int mr) {
        this.l = l;
        this.r = r;
        this.h = h;
        this.mr = mr;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    public List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length, mx = 0;
        Node root = null;
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            int l = p[0], r = l + p[1];
            int h = query(root, l, r);
            root = insert(root, l, r, h + p[1]);
            mx = Math.max(mx, h + p[1]);
            res.add(mx);
        }
        return res;
    }

    private Node insert (Node node, int l, int r, int h) {
        if (node == null) return new Node(l, r, h, r);
        if (l <= node.l) node.left = insert(node.left, l, r, h);
        else node.right = insert(node.right, l, r, h);
        if (r > node.mr) node.mr = r;
        return node;
    }

    private int query(Node node, int l, int r) {
        if (node == null || l >= node.mr) return 0;

        int h = 0;
        if (!(r <= node.l || l >= node.r)) h = node.h;

        h = Math.max(h, query(node.left, l, r));
        if (r > node.l) h = Math.max(h, query(node.right, l, r));
        return h;
    }

}
