package minReorder;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/12/7 上午9:29
 */
public class Solution {
    List<int[]>[] g;
    int res = 0;
    public int minReorder(int n, int[][] connections) {
        g = new List[n];
        Arrays.setAll(g , a-> new ArrayList<>());

        for (int[] c : connections) {
            g[c[0]].add(new int[]{c[1], 1});
            g[c[1]].add(new int[]{c[0], 0});
        }

        dfs(0, -1);
        return res;
    }

    private void dfs (int cur, int pre) {
        for (int[] next : g[cur]) {
            if(next[0] == pre) continue;
            if (next[1] == 0) res += 1;
            dfs(next[0], cur);
        }
    }

}
