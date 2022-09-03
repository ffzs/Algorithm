package findLongestChain;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/3 上午8:13
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int pre = Integer.MIN_VALUE, res = 0;
        for (int[] pair : pairs) {
            if (pre < pair[0]) {
                pre = pair[1];
                res += 1;
            }
        }
        return res;
    }
}
