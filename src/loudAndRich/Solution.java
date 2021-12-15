package loudAndRich;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/12/15 上午7:30
 */
public class Solution {
    private ArrayList<Integer>[] graph;
    private int[] quiet, res;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        this.quiet = quiet;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] ints : richer) {
            int a = ints[0], b = ints[1];
            graph[b].add(a);
        }
        res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs (int i) {
        if (res[i] != -1) return;

        res[i] = i;
        for (Integer integer : graph[i]) {
            dfs(integer);
            if (quiet[res[integer]] < quiet[res[i]]) res[i] = res[integer];
        }
    }

}
