package secondMinimum;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/1/24 上午8:20
 */
public class Solution {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] g = new List[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        int[][] distance = new int[n+1][2];
        for (int[] ints : distance) {
            Arrays.fill(ints, 10001);
        }
        distance[1][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1, 0});
        while (distance[n][1] == 10001) {
            int[] cur = q.poll();
            int id = cur[0], cnt = cur[1];
            for (int i : g[id]) {
                if (cnt + 1 < distance[i][0]) {
                    distance[i][0] = cnt + 1;
                    q.offer(new int[]{i, cnt + 1});
                }
                else if (cnt + 1 < distance[i][1]) {
                    if (cnt + 1 == distance[i][0]) continue;
                    distance[i][1] = cnt + 1;
                    q.offer(new int[] {i, cnt + 1});
                }
            }
        }

        int res = 0, t = 2 * change;
        for (int i = 0; i < distance[n][1]; i++) {
            if (res % t >= change) {
                res = ((res / t) + 1)*t;
            }
            res += time;
        }
        return res;
    }

}
