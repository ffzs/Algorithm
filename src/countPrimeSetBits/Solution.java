package countPrimeSetBits;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/5 上午8:35
 */
public class Solution {
    static boolean[] isPrime = new boolean[21];
    static int p = 0;
    static {
        int[] prime = {2,3,5,7,11,13,17,19};
        for (int i : prime) {
            isPrime[i] = true;
            p |= (1 << i);
        }
    }
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        System.out.println(p);
        for (int i = left; i <= right; i++) {
            int cnt = Integer.bitCount(i);
            if ((1 << cnt & p) != 0) {
                ++res;
            }
        }
        return res;
    }

}
