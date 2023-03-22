package bestTeamScore;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/3/22 上午8:27
 */
public class Solution {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] info = new int[n][2];
        for (int i = 0; i < n; i++) {
            info[i] = new int[] {scores[i], ages[i]};
        }

        Arrays.sort(info, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });

        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (info[j][1] >= info[i][1]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += info[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
