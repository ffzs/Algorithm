package judgeSquareSum;

/**
 * @author: ffzs
 * @Date: 2021/4/28 上午9:57
 */
public class Solution2 {

    public boolean judgeSquareSum(int c) {
        for (int i = 2; i*i <= c; i++) {
            if (c % i != 0) continue;
            int cnt = 0;
            while (c % i == 0) {
                c /= i;
                cnt ++;
            }
            if (i % 4 == 3 && cnt % 2 == 1) return false;
        }

        return c % 4 != 3;
    }

}
