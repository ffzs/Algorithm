package minSteps;

/**
 * @author: ffzs
 * @Date: 2021/9/19 上午6:56
 */
public class Solution {

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                res += i;
            }
        }
        if (n > 1) res += n;
        return res;
    }

}
