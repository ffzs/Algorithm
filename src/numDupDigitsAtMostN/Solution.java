package numDupDigitsAtMostN;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/3/20 上午9:02
 */
public class Solution {
    int[][] mem;
    char[] cs;
    public int numDupDigitsAtMostN(int n) {
        cs = String.valueOf(n).toCharArray();
        mem = new int[cs.length][1<<(cs.length+1)];
        for (int[] ints : mem) {
            Arrays.fill(ints, -1);
        }
        return n + 1 - f(0, 0, true);
    }

    private int f (int mask, int i, boolean isSame) {
        if (i == cs.length) return 1;

        if (!isSame && mem[i][mask] != -1) return mem[i][mask];
        int ret = 0;
        int t = isSame? cs[i] - '0' : 9;
        for (int j = 0; j <= t; j++) {
            if ((mask & (1<<j)) == 0) {
                ret += f(j == 0 && mask == 0 ? mask : mask | (1 << j), i + 1, isSame && j == t);
            }
        }

        if (!isSame) mem[i][mask] = ret;
        return ret;
    }

}
