package isPerfectSquare;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/11/4 上午7:15
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int l = 0, r = num/2;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            long cur = (long)mid * mid;
            if (cur == num) return true;
            else if (cur < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

}
