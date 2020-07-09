package respace;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/9
 */

class TrieNode {
    boolean isEnd = false;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

class Trie {
    public TrieNode root = new TrieNode();

    public Trie () {}

    public void insert(String word){
        TrieNode cur = root;
        for (int i = word.length()-1; i >=0 ; --i) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }
}




public class Solution2 {
    public static int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        Trie trie = new Trie();
        for (String s : dictionary) trie.insert(s);

        int[] dp = new int[len + 1];
        for (int i = 1; i < len + 1; ++i) {
            dp[i] = dp[i-1] + 1;
            TrieNode cur = trie.root;
            for (int j = i; j >= 1; --j) {
                int c = sentence.charAt(j-1) - 'a';
                if (cur.children[c] == null) break;
                cur = cur.children[c];
                if (cur.isEnd){
                    dp[i] = Math.min(dp[i], dp[j-1]);
                    if (dp[i] == 0) break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String[] dictionary = {"potimzz"};
        String sentence = "potimzzpotimzz";

        System.out.println(respace(dictionary, sentence));
    }
}
