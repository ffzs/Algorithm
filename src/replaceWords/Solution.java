package replaceWords;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/7 下午2:21
 */
class Node {
    Node[] children;
    boolean end;

    public Node() {
        this.children = new Node[26];
        this.end = false;
    }
}

class TrieTree {
    private Node root;

    public TrieTree() {
        this.root = new Node();
    }

    public void insert (String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.end = true;
    }

    public String query (String s) {
        Node cur = root;
        int i = 0;
        while (i < s.length() && !cur.end) {
            int it = s.charAt(i) - 'a';
            cur = cur.children[it];
            if (cur == null) return s;
            i += 1;
        }
        return s.substring(0, i);
    }
}

public class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieTree tt = new TrieTree();
        for (String s : dictionary) {
            tt.insert(s);
        }

        StringBuilder res = new StringBuilder();

        String[] ss = sentence.split(" ");
        for (String s : ss) {
            res.append(tt.query(s)).append(' ');
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

}
