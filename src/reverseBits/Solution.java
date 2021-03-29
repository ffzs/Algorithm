package reverseBits;

/**
 * @author: ffzs
 * @Date: 2021/3/29 上午8:36
 */
public class Solution {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            res += (n&1) << (31 - i);
            n >>>= 1;
        }

        return res;
    }

}
