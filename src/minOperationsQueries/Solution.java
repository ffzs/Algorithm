package minOperationsQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2024/1/26 下午8:02
 */
public class Solution {
    int W = 26;
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int m = queries.length;
        Map<Integer, Integer>[] neighbors = new Map[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new HashMap<>();
        }

        for (int[] edge : edges) {
            neighbors[edge[0]].put(edge[1], edge[2]);
            neighbors[edge[1]].put(edge[0], edge[2]);
        }

        List<int[]>[] queryArr = new List[n];
        for (int i = 0; i < n; i++) {
            queryArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            queryArr[queries[i][0]].add(new int[]{queries[i][1], i});
            queryArr[queries[i][1]].add(new int[]{queries[i][0], i});
        }

        int[][] count = new int[n][W+1];
        boolean[] visited = new boolean[n];
        int[] uf = new int[n];
        int[] lca = new int[m];
        tarjan(0, -1, neighbors, queryArr, count, visited, uf, lca);
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int totalCount = 0, maxCount = 0;
            for (int j = 0; j <= W; j++) {
                int t = count[queries[i][0]][j] + count[queries[i][1]][j] - 2 * count[lca[i]][j];
                maxCount = Math.max(maxCount, t);
                totalCount += t;
            }
            res[i] = totalCount - maxCount;
        }
        return res;

    }

    public void tarjan (int node, int parent, Map<Integer, Integer>[] neighbors, List<int[]>[] queryArr, int[][] count, boolean[] visited, int[] uf, int[] lca) {
        if (parent != -1) {
            System.arraycopy(count[parent], 0, count[node], 0, W+1);
            count[node][neighbors[node].get(parent)]++;
        }
        uf[node] = node;

        for (int child : neighbors[node].keySet()) {
            if (child == parent) {
                continue;
            }

            tarjan(child, node, neighbors, queryArr, count, visited, uf, lca);
            uf[child] = node;
        }

        for (int[] pair : queryArr[node]) {
            int a = pair[0], idx = pair[1];
            if (node != a && !visited[a]) {
                continue;
            }
            lca[idx] = find(uf, a);
        }
        visited[node] = true;
    }

    private int find(int[] uf, int i) {
        if (uf[i] == i) {
            return i;
        }
        uf[i] = find(uf, uf[i]);
        return uf[i];
    }

}
