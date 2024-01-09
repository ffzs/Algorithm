package minExtraChar;

import Trie.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/1/9 下午9:12
 */

class Node {
    Node[] child = new Node[26];
    boolean isEnd = false;
}

class TrieTree {
    Node root = new Node();

    public void add(String s){
        Node cur = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null) cur.child[i] = new Node();
            cur = cur.child[i];
        }
        cur.isEnd = true;
    }

    public List<Integer> check(char[] cs, int idx) {
        List<Integer> ret = new ArrayList<>();
        Node cur = root;
        int i = idx;
        while (i < cs.length && cur.child[cs[i] - 'a'] != null){
            cur = cur.child[cs[i] - 'a'];
            i++;
            if (cur.isEnd) ret.add(i);
        }
        return ret;
    }
}

public class Solution {

    public int minExtraChar(String s, String[] dictionary) {
        TrieTree tt = new TrieTree();
        for (String word : dictionary) {
            tt.add(word);
        }
        char[] cs = s.toCharArray();
        int[] dp = new int[cs.length+1];
        for (int i = 0; i < cs.length; i++) {
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            for (int j : tt.check(cs, i)) {
                dp[j] = Math.max(dp[j], dp[i] + j - i);
            }
        }
        return s.length() - dp[cs.length];
    }


}
