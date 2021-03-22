package hammingWeight;

/**
 * @author: ffzs
 * @Date: 2021/3/22 上午8:06
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
