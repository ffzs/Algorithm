package Trie;

/**
 * @author: ffzs
 * @Date: 2021/4/14 上午8:03
 */
public class Trie {
    static class TrieNode {
        public TrieNode[] node;
        private boolean isEnd;

        public TrieNode() {
            node = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs) {
            int i = c - 'a';
            if (cur.node[i] == null) cur.node[i] = new TrieNode();
            cur = cur.node[i];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = find(word);
        return cur != null && cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix) != null;
    }

    private TrieNode find(String word) {
        char[] cs = word.toCharArray();
        TrieNode cur = root;
        for (char c : cs) {
            int i = c - 'a';
            if (cur.node[i] == null) return cur.node[i];
            cur = cur.node[i];
        }
        return cur;
    }
}
