package WordDictionary;

/**
 * @author: ffzs
 * @Date: 2021/10/19 下午5:34
 */

class Node {
    public Node[] children;
    private boolean isEnd;
    public Node() {
        children = new Node[26];
        this.isEnd = false;
    }

    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}


public class WordDictionary {
    Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node cur = this.root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.setEnd(true);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int idx, Node node){
        if (idx == word.length()) return node.isEnd();

        char c = word.charAt(idx);
        if (c == '.'){
            for (Node child : node.children) {
                if (child != null && dfs(word, idx+1, child)) return true;
            }
        }
        else {
            Node cur = node.children[word.charAt(idx) - 'a'];
            return cur != null && dfs(word, idx + 1, cur);
        }

        return false;
    }

}
