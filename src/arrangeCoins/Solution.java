package arrangeCoins;

/**
 * @author: ffzs
 * @Date: 2021/10/10 上午6:51
 */
public class Solution {

    public int arrangeCoins(int n) {
        long l = 0, r = n;
        while (l <= r) {
            long mid = (l + r) >>>1;
            long c = ((mid+1) * mid) >>> 1;
            if (c == n) return (int)mid;
            else if (c < n) l = mid + 1;
            else r = mid - 1;
        }
        return (int)r;
    }
}
