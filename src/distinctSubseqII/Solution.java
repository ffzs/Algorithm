package distinctSubseqII;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/10/14 下午1:52
 * 如果不重复的话， abcd
 * 每一个就是自身和前面所有情况
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int distinctSubseqII(String s) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        int res = 0;
        for (char c : cs) {
            int other = res - cnt[c - 'a'];
            cnt[c - 'a'] = res + 1;
            res = ((other + cnt[c - 'a']) % MOD + MOD) % MOD;
        }
        return res;
    }

}
