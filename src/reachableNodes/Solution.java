package reachableNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2022/11/26 下午2:44
 */
public class Solution {
    static final int INF = Integer.MAX_VALUE >> 1;
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] edge : edges) {
            g[edge[0]].add(new int[]{edge[1], edge[2]});
            g[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        // [node_id, step -> 0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0,0});
        dist[0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int step = cur[1], nodeA = cur[0];
            if (visited[nodeA]) continue;
            visited[nodeA] = true;
            for (int[] node : g[nodeA]) {
                int nodeB = node[0], nodes = node[1], total = step + nodes + 1;
                if (total <= maxMoves && !visited[nodeB] && dist[nodeB] > total) {
                    dist[nodeB] = total;
                    pq.offer(new int[] {nodeB, total});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) res += 1;
        }
        for (int[] edge : edges) {
            int na = edge[0], nb = edge[1], nodes = edge[2], it = 0;
            if (visited[na]) it = maxMoves - dist[na];
            if (visited[nb]) it += maxMoves - dist[nb];
            res += Math.min(nodes, it);
        }
        return res;
    }

}
