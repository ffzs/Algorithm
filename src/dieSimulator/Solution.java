package dieSimulator;

/**
 * @author: ffzs
 * @Date: 2023/2/10 上午8:21
 */
public class Solution {
    static final int MOD = (int)1e9+7;
    public int dieSimulator(int n, int[] rollMax) {
        int[][] dist = new int[n+1][6];
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                int idx = Math.max(i - 1 - rollMax[j], 0);
                // sum[i-1] - sum[idx] + dist[idx][j]
                // 非j的状态可以通过 + [1, rollMax[j]] 范围内个j 转移； 同时也可以通过dist[idx][j] 转移
                int pre = ((sum[idx]-dist[idx][j]) % MOD + MOD) % MOD;
                dist[i][j] = ((sum[i-1] - pre) % MOD + MOD) % MOD;
                if (i <= rollMax[j]) dist[i][j] = (dist[i][j] + 1) % MOD;
                sum[i] = (sum[i] + dist[i][j]) % MOD;
            }
        }
        return sum[n];
    }

}
