package findCheapestPrice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2021/8/24 上午7:06
 */
public class Solution2 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = (int)(1e4) * 101 + 1;
        int[][] g = new int[n][n];
        for (int[] flight : flights) {
            g[flight[0]][flight[1]] = flight[2];
        }
        int[] res = new int[n];
        Arrays.fill(res, INF);

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{src, 0});
        for (int i = 0; i < k + 1; i++) {
            for (int size = qu.size(); size > 0; size--) {
                int[] cur = qu.poll();
                int t = cur[0], cost = cur[1];
                for (int j = 0; j < n; j++) {
                    if (g[t][j] != 0 && g[t][j] + cost < res[j]) {
                        res[j] = g[t][j] + cost;
                        qu.offer(new int[]{j, res[j]});
                    }
                }
            }
        }
        return res[dst] == INF? -1:res[dst];
    }

}
