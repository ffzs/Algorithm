package findAllConcatenatedWordsInADict;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/12/28 上午8:19
 */

class Node {
    Node[] children;
    boolean isEnd;
    public Node () {
        children = new Node[26];
        isEnd = false;
    }
}

class TrieTree {
    public Node root = new Node();
    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            int i = c-'a';
            if (cur.children[i] == null) {
                cur.children[i] = new Node();
            }
            cur = cur.children[i];
        }
        cur.isEnd = true;
    }
}

public class Solution {
    private TrieTree t = new TrieTree();
    boolean[] visited;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        if (words.length < 3) return res;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int minLen = words[0].length() * 2;
        for (String word : words) {
            if (word.length() == 0) continue;
            if (word.length() < minLen) {
                t.insert(word);
                continue;
            }
            visited = new boolean[word.length()];
            if (dfs(word, 0)) res.add(word);
            else t.insert(word);
        }
        return res;
    }

    private boolean dfs (String w, int start) {
        if (start == w.length()) return true;
        if (visited[start]) return false;
        visited[start] = true;
        Node cur = t.root;
        for (int i = start; i < w.length(); i++) {
            int v = w.charAt(i) - 'a';
            cur = cur.children[v];
            if (cur == null) return false;
            if (cur.isEnd) {
                if (dfs(w, i + 1)) return true;
            }
        }
        return false;
    }
}
