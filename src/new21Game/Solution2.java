package new21Game;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/3
 */
public class Solution2 {
    public double new21Game(int N, int K, int W) {
        if (K==0) return 1D;
        double[] dp = new double[N+1];
        double sum = 1D;
        dp[0] = 1D;
        for (int i = 1; i <= N; ++i) {
            dp[i] = 1D*sum/W;
            if (i<K) sum += dp[i];
            if (i>=W) sum -=dp[i-W];
        }
        double res = 0D;
        for (int i = K; i <= N; i++) {
            res += dp[i];
        }
        return res;
    }
}
