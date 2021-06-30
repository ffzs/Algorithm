package numWays2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/7/1 上午7:21
 */
public class Solution {

    int res = 0;
    List<Integer>[] map;
    int n, k;
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        map =  new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] ints : relation) {
            map[ints[0]].add(ints[1]);
        }
        dfs(0, 0);
        return res;
    }

    private void dfs(int idx, int level) {
        if (level == k) {
            if (idx == n-1) res++;
            return;
        }

        for (int i : map[idx]) {
            dfs(i, level+1);
        }
    }

}
