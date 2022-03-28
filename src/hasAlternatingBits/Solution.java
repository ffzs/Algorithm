package hasAlternatingBits;

/**
 * @author: ffzs
 * @Date: 2022/3/28 上午8:03
 */
public class Solution {

    public boolean hasAlternatingBits(int n) {
        int pre = n & 1;
        while (n > 0) {
            n >>= 1;
            int cur = n & 1;
            if (cur == pre) return false;
            pre = cur;
        }
        return true;
    }
}
