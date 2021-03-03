package countBits;

/**
 * @author: ffzs
 * @Date: 2021/3/3 上午8:03
 */
public class Solution {

    public int[] countBits(int num) {
        int n = num + 1;
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            res[i] = res[(i & (i-1))] + 1;
        }
        return res;
    }

}
