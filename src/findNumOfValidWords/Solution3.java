package findNumOfValidWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/2/26 上午10:46
 */

class TrieNode {
    int frq = 0;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

public class Solution3 {
    TrieNode root = new TrieNode();
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        for (String word : words) {
            char[] cs = word.toCharArray();
            boolean[] tmp = new boolean[26];
            for (char c : cs) tmp[c - 'a'] = true;

            add(root, tmp);
        }

        List<Integer> res = new ArrayList<>(puzzles.length);

        for (String puzzle : puzzles) {
            char[] cs = puzzle.toCharArray();
            Arrays.sort(cs);
            res.add(find(cs, puzzle.charAt(0), root, 0));
        }

        return res;
    }

    private void add (TrieNode root, boolean[] tmp) {
        TrieNode cur = root;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i]) {
                if (cur.children[i] == null) cur.children[i] = new TrieNode();
                cur = cur.children[i];
            }
        }
        cur.frq++;
    }

    private int find(char[] cs, char head, TrieNode cur, int pos) {
        if (cur == null) return 0;

        if (pos >= 7) return cur.frq;

        int ret = find(cs, head, cur.children[cs[pos] - 'a'], pos+1);

        if (cs[pos] != head) ret += find(cs, head, cur, pos+1);

        return ret;
    }
}
