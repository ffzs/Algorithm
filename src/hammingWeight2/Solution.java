package hammingWeight2;

/**
 * @author: ffzs
 * @Date: 2021/6/23 上午6:51
 */
public class Solution {

    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            n &= n-1;
            res ++ ;
        }

        return res;
    }

}
