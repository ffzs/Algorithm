package shortestToChar;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/19 上午8:17
 */
public class Solution {

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] res = new int[n];
        char[] cs = s.toCharArray();
        Arrays.fill(res, n);
        int cIdx = -1;
        for (int i = 0; i < n; i++) {
            if (cs[i] == c) cIdx = i;
            if (cIdx != -1 && Math.abs(i - cIdx ) < res[i]) {
                res[i] = Math.abs(i - cIdx);
            }
        }

        cIdx = -1;
        for (int i = n-1; i >= 0; i--) {
            if (cs[i] == c) cIdx = i;
            if (cIdx != -1 && Math.abs(i - cIdx ) < res[i]) {
                res[i] = Math.abs(i - cIdx);
            }
        }
        return res;
    }

}
