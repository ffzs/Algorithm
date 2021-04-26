package shipWithinDays;

/**
 * @author: ffzs
 * @Date: 2021/4/26 上午9:31
 */
public class Solution {

    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int left = weights[0];
        for (int i = 1; i < n; i++) {
            left = Math.max(left, weights[i]);
            weights[i] += weights[i-1];
        }
        int right = weights[n-1];

        while (left < right) {
            int mid = (left + right) >>> 1;
            int v = 0, counter = 1;
            for (int i = 0; i < weights.length; i++) {
                if (weights[i] - v > mid) {
                    v = weights[i-1];
                    counter ++;
                }
            }
            if (counter <= D) right = mid;
            else left = mid + 1;
        }

        return left;
    }

}
