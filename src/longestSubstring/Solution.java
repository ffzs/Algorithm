package longestSubstring;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/2/27 上午8:40
 */
public class Solution {

    public int longestSubstring(String s, int k) {

        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        int t = 0;
        for (char c : cs) {
            counter[c - 'a'] ++;
        }

        for (int i : counter) {
            if (i >= k) t++;
        }
//        System.out.println(Arrays.toString(counter));

        int res = 0;

        for (int i = 1; i <= t; i++) {
            int l = 0, r = 0;
            int[] tmp = new int[26];
            int tt = 0;
            int sub = 0;
            while (r < cs.length) {
                tmp[cs[r] - 'a'] ++;
                if (tmp[cs[r] - 'a'] == 1) {
                    tt++; sub++;
                }
                if (tmp[cs[r] - 'a'] == k) sub--;

                while (tt > i) {
                    tmp[cs[l] - 'a']--;
                    if (tmp[cs[l] - 'a'] == k-1) sub ++;
                    if (tmp[cs[l] - 'a'] == 0) {
                        tt --; sub--;
                    }
                    l++;
                }

                if (sub == 0) res = Math.max(res, r-l+1);
                r++;
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s= "bbaaacbd";
        String s= "aaabb";
        System.out.println(solution.longestSubstring(s, 3));
    }
}