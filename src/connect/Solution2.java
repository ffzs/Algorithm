package connect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/9/28 上午8:19
 */
public class Solution2 {

    Map<Integer, Node> map = new HashMap<>();
    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs (Node root, int level) {
        if (root != null) {

            dfs(root.right, level+1);
            dfs(root.left, level+1);

            root.next = map.getOrDefault(level, null);
            map.put(level, root);
        }
    }
}
