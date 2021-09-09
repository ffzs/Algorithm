package chalkReplacer;

/**
 * @author: ffzs
 * @Date: 2021/9/10 上午6:49
 */
public class Solution {

    public int chalkReplacer(int[] chalk, int k) {
        int sum = 0;
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if (sum > k) return i;
        }
        k = k % sum;
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += chalk[i];
            if (sum > k) return i;
        }
        return 0;
    }
}
