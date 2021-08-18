package reverseVowels;

import com.sun.security.jgss.GSSUtil;

/**
 * @author: ffzs
 * @Date: 2021/8/19 上午6:37
 */
public class Solution {

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        char[] vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        int l = 0, r = cs.length-1;
        while (l < r) {
            while (l < r && !isVowel(cs[l], vowel)) l++;
            while (l < r && !isVowel(cs[r], vowel)) r--;
            char tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;
            l++;
            r--;
        }
        return new String(cs);
    }

    private boolean isVowel(char i, char[] vowel) {

        for (char c : vowel) {
            if (i == c) return true;
        }
        return false;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("leetcode"));
    }
}
