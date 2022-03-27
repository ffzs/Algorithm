package missingRolls;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/27 上午8:36
 */
public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int t = (rolls.length + n) * mean;
        int cur = 0;
        for (int roll : rolls) {
            cur += roll;
        }
        int remain = t - cur;
        if ( remain > n * 6 || remain < n) return new int[0];
        int[] res = new int[n];

        Arrays.fill(res, remain/n);
        remain %= n;
        for (int i = 0; i < remain; i++) {
            res[i]++;
        }
        return res;
    }

}
