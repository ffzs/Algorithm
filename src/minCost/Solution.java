package minCost;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/25 上午8:53
 */
public class Solution {

    public int minCost(int[][] costs) {
        int n = costs.length;
        int[] f1 = new int[3], f2 = new int[3], tmp;
        for (int i = 0; i < 3; i++) f1[i] = costs[0][i];

        for (int i = 1; i < n; i++) {
            f2[0] = Math.min(f1[1], f1[2]) + costs[i][0];
            f2[1] = Math.min(f1[0], f1[2]) + costs[i][1];
            f2[2] = Math.min(f1[0], f1[1]) + costs[i][2];
            tmp = f2;
            f2 = f1;
            f1 = tmp;
        }
        return Math.min(f1[0], Math.min(f1[1], f1[2]));
    }
}
