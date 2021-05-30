package isPowerOfFour;

/**
 * @author: ffzs
 * @Date: 2021/5/31 上午7:44
 */
public class Solution {

    public boolean isPowerOfFour(int n) {
        int cnt = 0;

        while (n > 1) {
            if ((n & 1) == 1) return false;
            cnt++;
            n >>= 1;
        }

        return n == 1 && cnt % 2==0;
    }

}
