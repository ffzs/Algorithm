package findWords;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/9/16 上午6:52
 */

class Trie {
    String word;
    Map<Character, Trie> children;
    boolean isWord;

    public Trie() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Trie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}

public class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int n = board.length, m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(board, trie, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, Trie now, int i1, int j1) {
        char c = board[i1][j1];
        if (!now.children.containsKey(c)) return;

        Trie next = now.children.get(c);

        if (!next.word.equals("")) {
            res.add(next.word);
            next.word = "";
        }

        if (!next.children.isEmpty()) {
            board[i1][j1] = '#';
            for (int[] dir : directions) {
                int i2 = i1 + dir[0], j2 = j1 + dir[1];
                if (i2 >= 0 && i2 < board.length && j2 >= 0 && j2 < board[0].length) dfs(board, next, i2, j2);
            }
            board[i1][j1] = c;
        }
        if (next.children.isEmpty()) now.children.remove(c);
    }

}
