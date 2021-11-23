package buddyStrings;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/11/23 上午7:28
 */
public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) {
            int[] cnt = new int[26];
            for (char c : s.toCharArray()) {
                if (++cnt[c - 'a']>=2) return true;
            }
            return false;
        }
        int[] idx = new int[2];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (j >= 2) return false;
                idx[j++] = i;
            }
        }
        return s.charAt(idx[0]) == goal.charAt(idx[1]) && s.charAt(idx[1]) == goal.charAt(idx[0]);
    }
}

class  Test {
    public static void main(String[] args) {
        String s1 = "abcd", s2 = "bacd";
        Solution s = new Solution();
        System.out.println(s.buddyStrings(s1, s2));
    }
}
