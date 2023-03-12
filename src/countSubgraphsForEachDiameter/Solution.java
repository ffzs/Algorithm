package countSubgraphsForEachDiameter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2023/3/12 下午3:48
 */
public class Solution {

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {

        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            adj[x].add(y);
            adj[y].add(x);
        }
        int[] res = new int[n-1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 2; i < (1 << n); i++) {
            if (Integer.bitCount(i) == 1) continue;
            int x = Integer.numberOfTrailingZeros(i);
            int mask = i;
            int y = 0;
            q.offer(x);
            mask &= ~(1 << x);
            while (!q.isEmpty()) {
                y = q.poll();
                for (int v : adj[y]) {
                    if ((mask & (1<<v)) != 0) {
                        mask &= ~(1<<v);
                        q.offer(v);
                    }
                }
            }

            if (mask == 0) {
                int it = dfs(adj, -1, y, i);
                if (it > 0) res[it - 1] += 1;
            }
        }

        return res;
    }

    private int dfs (List<Integer>[] adj, int p, int node, int mask) {
        int ret = 0;
        for (int next : adj[node]) {
            if (next != p && (mask & (1<<next)) != 0) {
                ret = Math.max(ret, dfs(adj, node, next, mask) + 1);
            }
        }
        return ret;
    }

}
