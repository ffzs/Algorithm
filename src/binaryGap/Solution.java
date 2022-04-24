package binaryGap;

/**
 * @author: ffzs
 * @Date: 2022/4/24 上午8:22
 */
public class Solution {

    public int binaryGap(int n) {
        int pre = -1, idx = 0;
        int res = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (pre != -1) res = Math.max(res, idx - pre);
                pre = idx;
            }
            n >>= 1;
            ++idx;
        }
        return res;
    }

}
