package minimumTotalPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/6 上午10:25
 */
public class Solution {
    List<Integer>[] g;
    int[] cnt;
    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new List[n];
        cnt = new int[n];
        Arrays.setAll(g, a -> new ArrayList<>());

        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        for (int[] trip : trips) {
            dfs(trip[0], trip[1], -1);
        }

        int[] res = helper(0, price, -1);
        return Math.min(res[0], res[1]);
    }

    private int[] helper (int cur, int[] prices, int pre) {
        int a = prices[cur] * cnt[cur], b = a / 2;
        for (int next : g[cur]) {
            if (next == pre) continue;
            int[] ret = helper(next, prices, cur);
            a += Math.min(ret[0], ret[1]);
            b += ret[0];
        }
        return new int[]{a, b};
    }

    private boolean dfs (int start, int end, int pre) {
        if (start == end) {
            cnt[end] += 1;
            return true;
        }

        for (int next : g[start]) {
            if (next == pre) continue;
            if (dfs(next, end, start)) {
                cnt[start] += 1;
                return true;
            }
        }

        return false;
    }

}
