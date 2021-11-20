package maxDepth2;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/11/21 上午7:34
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
    int res = 0;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(Node node, int depth) {
         if (node.children == null) {
             res = Math.max(res, depth);
             return;
         }

        for (Node child : node.children) {
            dfs(child, depth + 1);
        }
    }

}
