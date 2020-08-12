package cloneGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/12 上午7:41
 */

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


public class Solution {

    Node[] step = new Node[101];

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (step[node.val] != null) return step[node.val];

        Node copyNode = new Node(node.val);
        step[node.val] = copyNode;

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }
}
