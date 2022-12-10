package maxHeight;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/12/10 上午11:37
 */
public class Solution {

    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        Arrays.sort(cuboids, (a, b) -> a[0] + a[1] + a[2] - b[0] - b[1] - b[2]);
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (compare(cuboids[i], cuboids[j])) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += cuboids[i][2];
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private boolean compare (int[] a, int[] b) {
        return a[0] >= b[0] && a[1] >= b[1] && a[2] >= b[2];
    }

}
