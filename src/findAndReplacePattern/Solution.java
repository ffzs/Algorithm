package findAndReplacePattern;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/6/12 上午8:45
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (isMatch(word, pattern)) res.add(word);
        }
        return res;
    }


    private boolean isMatch (String s, String pattern) {
        if (s.length() != pattern.length()) return false;

        int[] a2b = new int[26];
        int[] b2a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = pattern.charAt(i);
            if (a2b[a - 'a'] == 0) a2b[a - 'a'] = b;
            if (b2a[b - 'a'] == 0) b2a[b - 'a'] = a;
            if (a2b[a - 'a'] != b || b2a[b - 'a'] != a) return false;
        }
        return true;
    }
}
