package shortestAlternatingPaths;

import javax.swing.*;
import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/2/2 上午8:43
 */
public class Solution {
    static final int FILL = Integer.MAX_VALUE >> 1;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] edges = new List[2][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                edges[j][i] = new ArrayList<>();
            }
        }

        for (int[] r : redEdges) {
            edges[0][r[0]].add(r[1]);
        }

        for (int[] b : blueEdges) {
            edges[1][b[0]].add(b[1]);
        }

        int[][] dist = new int[2][n];
        Arrays.fill(dist[0], FILL);
        Arrays.fill(dist[1], FILL);
        dist[0][0] = 0;
        dist[1][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int team = cur[0], node = cur[1];
            for (int next : edges[team ^ 1][node]) {
                if (dist[team^1][next] != FILL) continue;
                dist[team^1][next] = dist[team][node] + 1;
                q.offer(new int[] {team^1, next});
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.min(dist[0][i], dist[1][i]);
            if (res[i] == FILL) res[i] = -1;
        }
        return res;
    }
}
