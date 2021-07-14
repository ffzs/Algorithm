package maximumElementAfterDecrementingAndRearranging;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/7/15 上午7:00
 */
public class Solution {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counter = new int[n+1];

        for (int i : arr) counter[Math.min(i, n)]++;

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res + counter[i], i);
        }
        return res;
    }
}
