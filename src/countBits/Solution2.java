package countBits;

/**
 * @author: ffzs
 * @Date: 2021/3/3 上午8:23
 */
public class Solution2 {

    public int[] countBits(int num) {
        int n = num + 1;
        int[] res = new int[n];

        int highBit = 0;
        for (int i = 1; i < n; i++) {
            if ((i & (i-1)) == 0) highBit = i;
            res[i] = res[i - highBit] + 1;
        }

        return res;
    }
}
