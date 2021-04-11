package nthUglyNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/4/11 上午9:24
 */
public class Solution2 {
    private static Ugly ugly = new Ugly();
    public int nthUglyNumber(int n) {
        return ugly.getN(n);
    }

    static class Ugly {
        private int[] dp = new int[1691];;
        public Ugly() {
            int i = 1, j = 1, k = 1;
            dp[1] = 1;
            for (int l = 2; l < dp.length; l++) {
                dp[l] = Math.min(dp[i]*2, Math.min(dp[j]*3, dp[k]*5));
                if (dp[l] == dp[i]*2) i++;
                if (dp[l] == dp[j]*3) j++;
                if (dp[l] == dp[k]*5) k++;
            }
        }

        public int getN(int n){
            return dp[n];
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.nthUglyNumber(10));
    }
}
