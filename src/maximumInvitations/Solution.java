package maximumInvitations;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/11/1 上午9:08
 */
public class Solution {

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] degree = new int[n];

        for (int i : favorite) {
            degree[i]++;
        }

        List<Integer>[] g = new List[n];
        Arrays.setAll(g, a -> new ArrayList<>());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        int[] depth = new int[n];
        while (!q.isEmpty()) {
            int x = q.poll(), y = favorite[x];
            depth[y] = Math.max(depth[y], depth[x] + 1);
            g[y].add(x);
            if (--degree[y] == 0) q.offer(y);
        }

        int maxRingSize = 0, linkSize = 0;
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                degree[i]--;
                int size = 1;
                int x = favorite[i];
                while (x != i) {
                    degree[x]--;
                    size ++;
                    x = favorite[x];
                }
                if (size == 2) {
                    linkSize += 2 + depth[i] + depth[favorite[i]];
                }
                else {
                    maxRingSize = Math.max(maxRingSize, size);
                }
            }
        }

        return Math.max(maxRingSize, linkSize);
    }

    private int dfs (int node, List<Integer>[] g) {
        int ret = 1;
        for (int next : g[node]) {
            ret = Math.max(ret, dfs(next, g) + 1);
        }
        return ret;
    }
}

