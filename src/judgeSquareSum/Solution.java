package judgeSquareSum;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/4/28 上午9:35
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        int l = 0, r = (int) Math.sqrt(c);

        while (l < r) {
            int v = l * l + r * r;
            if (v == c) return true;
            else if (v < c) l++;
            else r--;
        }

        return false;
    }
}
