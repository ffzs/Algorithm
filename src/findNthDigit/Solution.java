package findNthDigit;

/**
 * @author: ffzs
 * @Date: 2021/11/30 上午7:45
 */
public class Solution {
    public int findNthDigit(int n) {
        int d = 1, cnt = 9;
        while (n > (long) d * cnt) {
            n -= d * cnt;
            d ++;
            cnt *= 10;
        }
        int idx = n - 1;
        int start = (int)Math.pow(10, d-1);
        int cur = start + idx / d;
        int i = idx%d;
        return cur / (int)Math.pow(10, d - i - 1) % 10;
    }

}
