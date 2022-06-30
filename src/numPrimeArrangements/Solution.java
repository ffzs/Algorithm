package numPrimeArrangements;

import java.util.regex.Matcher;

/**
 * @author: ffzs
 * @Date: 2022/6/30 下午9:24
 */
public class Solution {
    int MOD = 1000000007;
    public int numPrimeArrangements(int n) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) cnt += 1;
        }
        return (int)(factorial(cnt) * factorial(n - cnt) % MOD);
    }

    private long factorial (int n) {
        long ret = 1;
        for (int i = 1; i <= n; i++) {
            ret *= i;
            ret %= MOD;
        }
        return ret;
    }

    private boolean isPrime (int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
