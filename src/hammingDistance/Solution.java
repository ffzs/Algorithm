package hammingDistance;

/**
 * @author: ffzs
 * @Date: 2021/5/27 上午8:31
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;

        int res = 0;
        while (z > 0) {
            if ((z & 1) == 1) res ++;
            z >>= 1;
        }
        return res;
    }
}
