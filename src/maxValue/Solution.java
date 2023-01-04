package maxValue;

/**
 * @author: ffzs
 * @Date: 2023/1/4 上午10:30
 */
public class Solution {

    public int maxValue(int n, int index, int maxSum) {
        long l = 0, r = maxSum;
        maxSum -= n;
        while (l < r) {
            long mid = (l + r + 1) >>> 1, total = mid * mid;
            if (mid > index) total -= (mid-index)*(mid-index-1)/2;
            if (mid > (n - index)) total -= (mid - (n - index - 1)) * (mid - (n - index - 1) - 1) / 2;
            if (total > maxSum) r = mid - 1;
            else l = mid;
        }
        return (int)l + 1;
    }

}
