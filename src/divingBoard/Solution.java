package divingBoard;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/8
 */
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter*k};
        int[] res = new int[k+1];
        for (int i = 0; i <= k; ++i) {
            res[i] = shorter*(k-i) + longer*i;
        }
        return res;
    }
}
