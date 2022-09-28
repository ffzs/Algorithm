package getKthMagicNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/28 下午12:19
 */
public class Solution {

    public int getKthMagicNumber(int k) {
        int[] tmp = new int[k];
        tmp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            int num3 = tmp[p3] * 3, num5 = tmp[p5] * 5, num7 = tmp[p7] * 7;
            tmp[i] = Math.min(num3, Math.min(num5, num7));
            if (tmp[i] == num3) p3 += 1;
            if (tmp[i] == num5) p5 += 1;
            if (tmp[i] == num7) p7 += 1;
        }
        return tmp[k-1];
    }

}
