package count;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2024/1/16 下午9:28
 */
public class Solution {
    private static final int MOD = (int) 1e9 + 7;

    public int count(String num1, String num2, int minSum, int maxSum) {
        int res = (calculate(num2, minSum, maxSum) - calculate(num1, minSum, maxSum) + MOD) % MOD;
        int total = 0;
        for (char c : num1.toCharArray()) {
            total += c - '0';
        }
        if (total >= minSum && total <= maxSum) res += 1;
        return res;
    }

    private int calculate (String s, int minSum, int maxSum){
        int n = s.length();
        int[][] memo = new int[n][Math.min(9*n, maxSum) + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return dfs(0, 0, true, s.toCharArray(), minSum, maxSum, memo);
    }

    private int dfs(int idx, int total, boolean isLimit, char[] cs, int minSum, int maxSum, int[][] memo) {
        if (total > maxSum) return 0;

        if (idx == cs.length) {
            return total >= minSum ? 1 : 0;
        }

        if (!isLimit && memo[idx][total] != -1) return memo[idx][total];

        int up = isLimit ? cs[idx] - '0' : 9;

        int res = 0;
        for (int d = 0; d <= up; d++) {
            res = (res + dfs(idx + 1, total + d, isLimit && (d == up), cs, minSum, maxSum, memo)) % MOD;
        }

        if (!isLimit) memo[idx][total] = res;
        return res;
    }

}

