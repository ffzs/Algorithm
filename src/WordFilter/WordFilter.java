package WordFilter;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/7/14 上午8:21
 */

class Node {
    Node[] children = new Node[26];
    Set<Integer> index = new HashSet<>();
}

class TrieTree {
    Node root = new Node();

    public void insert (String s, int idx) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int it = c - 'a';
            if (cur.children[it] == null) cur.children[it] = new Node();
            cur = cur.children[it];
            cur.index.add(idx);
        }
    }

    public Set<Integer> findAll (String s) {
        Node cur = root;
        for (char c : s.toCharArray()) {
            int it = c - 'a';
            if (cur.children[it] == null) return null;
            cur = cur.children[it];
        }
        return cur.index;
    }
}

public class WordFilter {
    TrieTree pre, suf;
    public WordFilter(String[] words) {
        pre = new TrieTree();
        suf = new TrieTree();
        HashSet<String> set = new HashSet<>();
        for (int i = words.length-1; i >= 0; i-=1) {
            String s = words[i];
            if (set.add(s)) {
                pre.insert(s, i);
                suf.insert(new StringBuilder(s).reverse().toString(), i);
            }
        }
    }

    public int f(String pref, String suff) {
        Set<Integer> preSet = pre.findAll(pref);
        if (preSet == null) return -1;
        Set<Integer> sufSet = suf.findAll(new StringBuilder(suff).reverse().toString());
        if (sufSet == null) return -1;
        int ret = -1;
        for (int i : preSet) {
            if (sufSet.contains(i)) ret = Math.max(ret, i);
        }
        return ret;
    }
}
