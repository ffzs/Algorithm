package catMouseGame;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/1/4 上午8:27
 */
public class Solution {
    int[][][] f;
    int[][] g;
    int n;
    public int catMouseGame(int[][] graph) {
        g = graph;
        n = g.length;
        f = new int[2 * n][n][n];
        for (int[][] value : f) {
            for (int[] ints : value) {
                Arrays.fill(ints, -1);
            }
        }
        return dfs(0, 1, 2);
    }

    private int dfs (int k, int a, int b) {
        int ret = f[k][a][b];
        if (a == 0) ret = 1;
        else if (a == b) ret = 2;
        else if (k == 2 * n) ret = 0;
        else if (ret == -1) {
            if (( k & 1) == 0) {
                ret = 2;
                for (int l : g[a]) {
                    int state = dfs(k + 1, l, b);
                    if (state == 1) {
                        ret = 1;
                        break;
                    }
                    else if (state == 0) {
                        ret = 0;
                    }
                }
            }
            else {
                ret = 1;
                for (int l : g[b]) {
                    if (l == 0) continue;
                    int state = dfs(k + 1, a, l);
                    if (state == 2) {
                        ret = 2;
                        break;
                    }
                    else if (state == 0) ret = 0;
                }
            }
        }
        return f[k][a][b] = ret;
    }
}
