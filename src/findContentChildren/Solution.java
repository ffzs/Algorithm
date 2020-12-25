package findContentChildren;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/25 下午8:57
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0, i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
                j++;
                res++;
            }
            else j++;
        }

        return res;
    }
}
