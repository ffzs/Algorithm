package shortestPalindrome;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/8/29 上午8:15
 */
public class Solution2 {
    public String shortestPalindrome(String s) {
        char[] seq = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (int i = seq.length-1; i >= 0; --i) {
            if (isPalindrome(seq, i)) {
                for (int j = seq.length-1; j > i; j--) res.append(seq[j]);
                res.append(seq);
                return res.toString();
            }
        }
        return res.toString();
    }

    private boolean isPalindrome (char[] seq, int right) {
        int left = 0;
        while (left<=right) {
            if (seq[left++] != seq[right--]) return false;
        }
        return true;
    }
}
