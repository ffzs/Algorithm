package maxSatisfied;

/**
 * @author: ffzs
 * @Date: 2021/2/23 上午10:51
 */
public class Solution2 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }

        int res = 0, mask = 0;
        int i = 0;
        while (i < n) {
            mask += customers[i];
            if (i >= X-1) {
                res = Math.max(mask, res);
                mask -= customers[i - X + 1];
            }
            i++;
        }
        return res + sum;
    }
}
