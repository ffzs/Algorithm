package minimumFuelCost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/5 上午9:43
 */
public class Solution {
    List<Integer>[] g;
    int seats;
    long[] cnt;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        this.seats = seats;
        g = new List[n];
        cnt = new long[n];
        Arrays.setAll(g, a -> new ArrayList<>());

        for (int[] r : roads) {
            g[r[0]].add(r[1]);
            g[r[1]].add(r[0]);
        }

        dfs(0, -1);

        long res = 0;
        for (int i = 1; i < cnt.length; i++) {
            long v = cnt[i];
            res += (v % seats == 0 ? v/seats : v/seats + 1);
        }
        return res;
    }

    private long dfs (int i, int pre) {
        long ret = 1;
        for (int j : g[i]) {
            if (j == pre) continue;
            ret += dfs(j, i);
        }
        cnt[i] = ret;
        return ret;
    }

}
