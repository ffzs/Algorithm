package minimumPossibleSum;

/**
 * @author: ffzs
 * @Date: 2024/3/8 下午7:16
 */
public class Solution {
    private final static int MOD = (int) 1e9 + 7;
    public int minimumPossibleSum(int n, int target) {
        int m = target / 2;
        if (n <= m) {
            return (int)((long) (1 + n) * n / 2 % MOD);
        }

        return (int)(((long)(1 + m) * m / 2 + ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }

}
