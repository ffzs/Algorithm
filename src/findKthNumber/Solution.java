package findKthNumber;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/23 上午8:38
 */
public class Solution {

    private int move (int cur, long num) {
        int ret = 0;
        long l = cur, r = cur;
        while (l <= num) {
            ret += Math.min(r, num) - l + 1;
            l *= 10;
            r = r * 10 + 9;
        }
        return ret;
    }

    public int findKthNumber(int n, int k) {
        int res = 1;
        --k;
        while (k > 0) {
            int ret = move(res, n);
            if (ret <= k) {
                k -= ret;
                ++res;
            }
            else {
                res *= 10;
                --k;
            }
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findKthNumber(13,2));
//        System.out.println(s.helper(1, 2));
    }
}
