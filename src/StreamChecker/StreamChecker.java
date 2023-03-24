package StreamChecker;

/**
 * @author: ffzs
 * @Date: 2023/3/24 上午8:23
 */
class Node {
    public Node[] children;
    public boolean isEnd;

    public Node() {
        this.children = new Node[26];
        this.isEnd = false;
    }
}

class Trie {

    Node root;
    public Trie() {
        this.root = new Node();
    }

    public void add (String sb) {
        Node cur = root;
        for (int i = sb.length()-1; i >= 0; --i) {
            int idx = sb.charAt(i) - 'a';
            if (cur.children[idx] == null) cur.children[idx] = new Node();
            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public boolean search (StringBuilder sb) {
        Node cur = root;
        for (int i = sb.length()-1; i >= 0; --i) {
            int idx = sb.charAt(i) - 'a';
            if (cur.children[idx] == null) return false;
            cur = cur.children[idx];
            if (cur.isEnd) return true;
        }
        return false;
    }
}

public class StreamChecker {
    Trie trie;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return trie.search(sb);
    }

}
