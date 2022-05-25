package findSubstringInWraproundString;

/**
 * @author: ffzs
 * @Date: 2022/5/25 上午8:47
 */
public class Solution {

    public int findSubstringInWraproundString(String p) {
        int[] f = new int[26];
        int cnt = 0;
        char[] cs = p.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i > 0 && (((cs[i] - cs[i-1]) == 1) || (cs[i] == 'a' && cs[i-1] == 'z'))) ++cnt;
            else cnt = 1;
            f[cs[i] - 'a'] = Math.max(f[cs[i] - 'a'], cnt);
        }
        int res = 0;
        for (int i : f) {
            res += i;
        }
        return res;
    }

}
