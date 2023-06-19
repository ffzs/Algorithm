package connectTwoGroups;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/6/20 上午7:04
 */
public class Solution {
    int[][] memo;
    int INF = Integer.MAX_VALUE >> 1;
    int[] minCol;
    int m,n;
    public int connectTwoGroups(List<List<Integer>> cost) {
        m = cost.size(); n = cost.get(0).size();
        memo = new int[m+1][1<<n];
        for (int[] ints : memo) {
            Arrays.fill(ints, INF);
        }

        minCol = new int[n];
        Arrays.fill(minCol, INF);
        for (List<Integer> list : cost) {
            for (int j = 0; j < n; j++) {
                minCol[j] = Math.min(minCol[j], list.get(j));
            }
        }
        return dfs(0, 0, cost);
    }

    private int dfs (int i, int j, List<List<Integer>> cost) {
        if (memo[i][j] != INF) return memo[i][j];

        int ret = 0;
        if (i == m) {
            for (int k = 0; k < n; k++) {
                if ((j & (1<<k)) == 1) ret += minCol[k];
            }
            return memo[i][j] = ret;
        }

        ret = INF;

        for (int k = 0; k < n; k++) {
            ret = Math.min(ret, dfs(i + 1, j | (1<<k), cost) + cost.get(i).get(k));
        }
        return memo[i][j] = ret;
    }

}
