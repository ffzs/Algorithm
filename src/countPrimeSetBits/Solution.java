package countPrimeSetBits;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/5 上午8:35
 */
public class Solution {
    static int p = 0;
    static {
        int[] prime = {2,3,5,7,11,13,17,19};
        for (int i : prime) {
            p |= (1 << i);
        }
    }
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            if ((1 << Integer.bitCount(i) & p) != 0) {
                ++res;
            }
        }
        return res;
    }

}
