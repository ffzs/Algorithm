package networkDelayTime;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/8/2 上午6:54
 */
public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE/2;
        int[][] g = new int[n][n];

        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }

        for (int[] t : times) {
            g[t[0]-1][t[1]-1] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        boolean[] visited = new boolean[n];

        dist[k-1] = 0;

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!visited[y] && (x == -1 || dist[y] < dist[x])) x = y;
            }
            visited[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int res = 0;
        for (int i : dist) {
            res = Math.max(i, res);
        }
        return res == INF? -1:res;
    }

}
