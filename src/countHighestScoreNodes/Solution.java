package countHighestScoreNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/3/11 上午8:04
 */
public class Solution {
    long max;
    int n, res;
    int[][] children;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        max = 0;
        res = 0;
        children = new int[2][n];
        Arrays.fill(children[0], -1);
        Arrays.fill(children[1], -1);

        for (int i = 1; i < n; i++) {
            int p = parents[i];
            if (children[0][p] == -1) children[0][p] = i;
            else children[1][p] = i;
        }
        dfs(0);
        return res;
    }

    private int dfs (int node) {
        long s = 1;
        int size = n - 1;
        for (int i = 0; i < 2; i++) {
            if (children[i][node] != -1) {
                int t = dfs(children[i][node]);
                s *= t;
                size -= t;
            }
        }

        if (node != 0) s *= size;

        if (s == max) res++;
        else if (s > max) {
            res = 1;
            max = s;
        }
        return n - size;
    }

}
