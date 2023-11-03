package connect;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2023/11/3 上午9:11
 */
public class Solution4 {

    Node[] map = new Node[100];
    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    private void dfs (Node root, int level) {
        if (root != null) {

            dfs(root.right, level+1);
            dfs(root.left, level+1);

            root.next = map[level];
            map[level] = root;
        }
    }

}
