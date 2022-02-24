package findBall;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/2/24 上午8:52
 *
 * 1 -> [0, 1] -> if ([0,1] == 1) [1, 0] else end;
 * -1 -> [0, -1] -> if ([0,-1] == -1) [1, 0] else end;
 */
public class Solution {

    public int[] findBall(int[][] grid) {
        int n = grid[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            int cur = j;
            for (int[] ints : grid) {
                int move = ints[cur];
                cur += move;
                if (cur < 0 || cur >= n || ints[cur] != move) {
                    cur = -1;
                    break;
                }
            }
            res[j] = cur;
        }
        return res;
    }

}
