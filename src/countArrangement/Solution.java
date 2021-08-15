package countArrangement;

/**
 * @author: ffzs
 * @Date: 2021/8/16 上午7:00
 */
public class Solution {

    public int countArrangement(int n) {
        int len = 1<<n;
        int[] f = new int[len];
        f[0] = 1;
        for (int mask = 0; mask < len; mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) !=0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[len-1];
    }
}
