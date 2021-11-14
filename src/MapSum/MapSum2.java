package MapSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/14 上午7:34
 */

class TrieTree {
    TrieTree[] children;
    int val;

    public TrieTree() {
        children = new TrieTree[26];
        val = 0;
    }
}
public class MapSum2 {
    private TrieTree root;

    public MapSum2() {
        root = new TrieTree();
    }

    public void insert(String key, int val) {
        TrieTree cur = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new TrieTree();
            cur = cur.children[idx];
        }
        cur.val = val;
    }

    public int sum(String prefix) {
        TrieTree cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children[c-'a'];
            if (cur == null) return 0;
        }
        return dfs(cur);
    }

    private int dfs(TrieTree node) {
        int ret = node.val;
        for (TrieTree child : node.children) {
            if (child != null) ret += dfs(child);
        }
        return ret;
    }

}
