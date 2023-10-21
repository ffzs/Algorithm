package countPairs3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/10/21 上午8:51
 */
public class Solution {
    List<Integer>[] lst;
    boolean[] visited;
    public long countPairs(int n, int[][] edges) {
        lst = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            lst[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            lst[a].add(b);
            lst[b].add(a);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int v = dfs(i);
                res += (long)v * (n-v);
            }
        }
        return res / 2;
    }

    private int dfs (int a) {
        int ret = 1;
        visited[a] = true;
        for (int b : lst[a]) {
            if (!visited[b]) {
                ret += dfs(b);
            }
        }
        return ret;
    }

}
