package maxRepeating;

/**
 * @author: ffzs
 * @Date: 2022/11/3 下午6:37
 */
public class Solution {

    public int maxRepeating(String sequence, String word) {
        int res = 0, len = word.length();
        char[] cs = sequence.toCharArray(), wcs = word.toCharArray();
        for (int i = 0; i + (res + 1) * len - 1 < cs.length; i++) {
            if (cs[i] == wcs[0]) {
                int ret = helper(cs, i, wcs);
                res = Math.max(ret, res);
                if (ret > 1) i += (ret-1) * len;
            }
        }
        return res;
    }

    private int helper(char[] cs, int idx, char[] word) {
        int ret = 0;
        while (idx < cs.length) {
            for (char c : word) {
                if (idx == cs.length || cs[idx++] != c) return ret;
            }
            ret += 1;
        }
        return ret;
    }

}
