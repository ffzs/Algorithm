package minSwapsCouples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/11/11 上午8:10
 */
public class Solution2 {

    List<Integer>[] g;
    boolean[] visited;
    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        g = new List[n];
        Arrays.setAll(g, a->new ArrayList<>());
        visited = new boolean[n];

        for (int i = 0; i < row.length; i += 2) {
            int x = row[i]/2, y = row[i+1]/2;
            g[x].add(y);
            g[y].add(x);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) res += dfs(i)-1;
        }

        return res;
    }

    private int dfs (int i) {
        if (visited[i]) return 0;
        visited[i] = true;
        int cnt = 1;
        for (int j : g[i]) {
            cnt += dfs(j);
        }
        return cnt;
    }

}
