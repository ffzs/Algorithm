package findRotateSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/11/11 上午9:14
 */
public class Solution {

    public int findRotateSteps(String ring, String key) {
        char[] rc = ring.toCharArray();
        char[] kc = key.toCharArray();
        int n = rc.length, m = kc.length;
        List<Integer>[] tmp = new List[26];
        for (int i = 0; i < 26; i++) tmp[i] = new ArrayList<>();
        for (int i = 0; i < rc.length; i++) tmp[rc[i] - 'a'].add(i);

        int[][] dp = new int[m][n];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);

        for (int i : tmp[kc[0]-'a']) {
            dp[0][i] = Math.min(i, n-i);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j : tmp[kc[i]-'a']) {
                for (int k : tmp[kc[i - 1] - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.min(Math.abs(j-k), n-Math.abs(j-k)));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp[m - 1]) {
            res = Math.min(res, i);
        }
        return res + m;
    }

}
