package palindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/8/6 上午8:05
 */

class TrieNode {
    int isEnd = -1;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

class Trie {
    public Trie(){}

    public TrieNode root = new TrieNode();

    public void insert (String word, int index) {
        TrieNode cur = root;
        for (int i = word.length()-1; i >= 0; --i) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null)
                cur.children[c] = new TrieNode();
            cur = cur.children[c];
        }
        cur.isEnd = index;
    }

    public int find(String s, int l, int r) {
        TrieNode cur = root;
        for (int i = l; i < r+1; ++i) {
            int c = s.charAt(i) - 'a';
            if (cur.children[c] == null) return -1;
            cur = cur.children[c];
        }
        return cur.isEnd;
    }
}

public class Solution2 {

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        List<List<Integer>> res = new ArrayList<>();
        // 构建前缀树并将单词逆向写入
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i], i);
        }
        for (int i = 0; i < n; ++i) {
            int m =words[i].length();
            for (int j = 0; j < m+1; ++j) {
                if (palindrome(words[i], j, m-1)) {
                    int id = trie.find(words[i], 0, j-1);
                    if (id != -1 && id != i) res.add(Arrays.asList(i, id));
                }

                if (j > 0 && palindrome(words[i], 0, j-1)) {
                    int id = trie.find(words[i], j ,m-1);
                    if (id != -1 && id != i) res.add(Arrays.asList(id, i));
                }
            }
        }
        return res;
    }

    private boolean palindrome (String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;
            r --;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        Solution2 s = new Solution2();
        System.out.println(s.palindromePairs(words));
    }
}
