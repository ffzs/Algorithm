package minOperations4;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/12/2 下午8:11
 */
public class Solution {

    public int[] minOperations(String boxes) {
        char[] cs = boxes.toCharArray();
        int n = cs.length;
        int[] left = new int[n];
        int cnt = 0, total = 0;
        for (int i = 0; i < n; i++) {
            left[i] = cnt;
            if (cs[i] == '1') {
                cnt += 1;
                total += i;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int num = left[i + 1];
            left[i] = total;
            total = total + 2 * num - cnt;
        }
        left[n-1] = total;
        return left;
    }

}
