package calPoints;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/26 上午7:59
 */
public class Solution {

    public int calPoints(String[] ops) {
        int n = ops.length;
        int[] tmp = new int[n];
        int mask = Integer.MAX_VALUE/2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ops[i].equals("C")) {
                int j = i - 1;
                while (j >= 0 && tmp[j] == mask) --j;
                tmp[j] = mask;
                tmp[i] = mask;
            }
            else if (ops[i].equals("D")) {
                int j = i - 1;
                while (j >= 0 && tmp[j] == mask) --j;
                tmp[i] = tmp[j] * 2;
            }
            else if (ops[i].equals("+")) {
                int j = i - 1;
                while (j >= 0 && tmp[j] == mask) --j;
                tmp[i] = tmp[j--];
                while (j >= 0 && tmp[j] == mask) --j;
                tmp[i] += tmp[j];
            }
            else {
                tmp[i] = Integer.parseInt(ops[i]);
            }
        }
        for (int i : tmp) {
            if (i != mask) res += i;
        }
        return res;
    }

}
