package canIWin;

/**
 * @author: ffzs
 * @Date: 2022/5/22 上午8:18
 */
public class Solution {

    int[] memo;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        memo = new int[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    private boolean dfs (int max, int num, int desiredTotal, int total) {
        if (memo[num] == 0) {
            for (int i = 0; i < max; i++) {
                if (((num >> i) & 1) == 0) {
                    int cur = i + 1 + total;
                    if (cur >= desiredTotal || !dfs(max, num | (1 << i), desiredTotal, cur)) {
                        memo[num] = 1;
                        return true;
                    }
                }
            }
            memo[num] = 2;
        }
        return memo[num] == 1;
    }
}
