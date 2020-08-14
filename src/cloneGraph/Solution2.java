package cloneGraph;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/8/12 上午8:16
 */


public class Solution2 {
    Map<Node, Node> step = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        return dfs(node);
    }

    private Node dfs (Node node) {
        if (step.containsKey(node)) return step.get(node);

        Node copyNode = new Node(node.val);
        step.put(node, copyNode);

        for (Node neighbor : node.neighbors) {
            copyNode.neighbors.add(cloneGraph(neighbor));
        }

        return copyNode;
    }
}
