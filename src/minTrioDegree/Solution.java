package minTrioDegree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/8/31 上午7:26
 */
public class Solution {

    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] g = new Set[n];
        for (int i = 0; i < n; i++) {
            g[i] = new HashSet<>();
        }
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int a = edge[0]-1, b = edge[1]-1;
            g[a].add(b);
            g[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        List<Integer>[] h = new List[n];
        for (int i = 0; i < n; i++) {
            h[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0]-1, b = edge[1]-1;
            if (degree[a] < degree[b] || (degree[a] == degree[b] && a < b)) {
                h[a].add(b);
            }
            else {
                h[b].add(a);
            }
        }

        int res = Integer.MAX_VALUE;

        for (int a = 0; a < n; a++) {
            if (degree[a] < 2 || degree[a] * 3 > res) continue;
            for (int b : h[a]) {
                if (degree[b] < 2) continue;
                for (int c : h[b]) {
                    if (degree[c] < 2) continue;
                    if (g[c].contains(a)) {
                        res = Math.min(res, degree[a] + degree[b] + degree[c]);
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res-6;
    }

}
