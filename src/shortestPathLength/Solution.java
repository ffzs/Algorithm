package shortestPathLength;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2021/8/6 上午6:54
 */
public class Solution {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][1<<n];

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1<<i, 0});
            visited[i][1<<i] = true;
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] == (1<<n) - 1) {
                res = cur[2];
                break;
            }
            for (int i : graph[cur[0]]) {
                int mask = cur[1]|1<<i;
                if (!visited[i][mask]) {
                    queue.offer(new int[]{i, mask, cur[2] + 1});
                    visited[i][mask] = true;
                }
            }
        }
        return res;
    }

}
