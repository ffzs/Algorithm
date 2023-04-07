package numMovesStonesII;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/7 下午4:49
 */
public class Solution {

    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int m1 = stones[n-2] - stones[0] - n + 2;
        int m2 = stones[n-1] - stones[1] - n + 2;

        int max = Math.max(m1, m2);
        if (m1 == 0 || m2 == 0) return new int[] {Math.min(2, max), max};

        int l = 0, res = 0;
        for (int r = 0; r < n; r++) {
            while (l <= r && stones[r] - stones[l] + 1 > n) {
                l ++;
            }
            res = Math.max(res,r - l + 1);
        }
        return new int[] {n - res, max};
    }

}
