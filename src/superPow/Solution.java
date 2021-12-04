package superPow;

/**
 * @author: ffzs
 * @Date: 2021/12/5 上午7:34
 */
public class Solution {
    static private int MOD = 1337;
    public int superPow(int a, int[] b) {
        int n = b.length;
        int res = 1, x = a % MOD;

        for (int i =  n - 1; i >= 0; --i) {
            res = res * qPow(x, b[i]) % MOD;
            x = qPow(x , 10);
        }
        return res;
    }

    private int qPow(int x, int n) {
        int ret = 1;
        while (n > 0) {
            if ((n & 1) == 1) ret = ret * x % MOD;
            x = x * x % MOD;
            n >>= 1;
        }
        return ret;
    }

}
