package closeStrings;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/11/30 上午8:44
 */
public class Solution {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] c1 = counter(word1), c2 = counter(word2);

        for (int i = 0; i < 26; i++) {
            if (c1[i]*c2[i] == 0 && c1[i] + c2[i] > 0) return false;
        }

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < 26; i++) {
            if (c1[i] != c2[i]) return false;
        }

        return true;
    }

    private int[] counter (String s) {
        char[] cs = s.toCharArray();
        int[] ret = new int[26];
        for (char c : cs) {
            ret[c - 'a'] ++;
        }
        return ret;
    }

}
