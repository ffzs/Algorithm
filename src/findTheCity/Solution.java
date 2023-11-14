package findTheCity;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/11/14 上午8:47
 */
public class Solution {
    static final int INF = Integer.MAX_VALUE >> 1;
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] g = new int[n][n];
        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }

        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = e[2];
        }

        for (int k = 0; k < n; k++) {
            g[k][k] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }

        int res = -1, cnt, minC = INF;
        for (int i = 0; i < n; i++) {
            cnt = 0;
            for (int j = 0; j < n; j++) {
                if (g[i][j] <= distanceThreshold) cnt += 1;
            }
            if (cnt <= minC) {
                minC = cnt;
                res = i;
            }
        }

        return res;
    }

}
