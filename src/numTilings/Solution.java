package numTilings;

/**
 * @author: ffzs
 * @Date: 2022/11/12 下午2:58
 */
public class Solution {
    static final int MOD = (int)1e9 + 7;
    public int numTilings(int n) {
        if (n == 1) return 1;
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i < f.length; i++) {
            f[i] = (f[i-1] * 2 + f[i - 3]) % MOD;
        }
        return (int)f[n];
    }

}
