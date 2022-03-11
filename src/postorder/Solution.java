package postorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/3/12 上午7:36
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return res;
    }

    private void dfs (Node node) {
        if (node == null) return;

        for (Node child : node.children) {
            dfs(child);
        }

        res.add(node.val);
    }

}
