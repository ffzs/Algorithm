package rotatedDigits;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/25 下午7:17
 * 2,5,6,9,0,1,8 7个
 */
public class Solution {
    static final int[] mark = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    public int rotatedDigits(int n) {
        char[] cs = Integer.toString(n).toCharArray();
        int m = cs.length;
        int[][] f = new int[m][2];
        for (int[] ints : f) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0 , true, cs, f);
    }

    private int dfs (int idx, int isValid, boolean maxNum, char[] cs, int[][] f) {
        if (idx == cs.length) return isValid;
        if (!maxNum && f[idx][isValid] != -1) return f[idx][isValid];

        int res = 0;
        for (int i = 0; i <= (maxNum ? cs[idx]-'0':9); i++) {
            if (mark[i] != -1) res += dfs(idx + 1, isValid | mark[i], maxNum && (i == cs[idx]-'0'), cs, f);
        }
        if (!maxNum) f[idx][isValid] = res;
        return res;
    }

}
