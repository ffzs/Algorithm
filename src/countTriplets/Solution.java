package countTriplets;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/5/18 上午8:40
 */
public class Solution {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] total = new int[n + 1];

        total[0] = 0;
        for (int i = 1; i <= n; i++) {
            total[i] = total[i-1]^arr[i - 1];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j; k <= n; k++) {
                    if ((total[j - 1] ^ total[i - 1]) == (total[k] ^ total[j-1])) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
