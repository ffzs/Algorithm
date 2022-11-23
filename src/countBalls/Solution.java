package countBalls;

/**
 * @author: ffzs
 * @Date: 2022/11/23 下午4:24
 */
public class Solution {

    public int countBalls(int lowLimit, int highLimit) {
        int[] b = new int[46];
        int pre = liSum(lowLimit);
        for (int i = lowLimit; i <= highLimit; i++) {
            if (i % 10 == 0) pre = liSum(i);
            b[pre++] += 1;
        }
        int res = 0;
        for (int i : b) {
            if (i > res) res = i;
        }
        return res;
    }

    private int liSum (int num) {
        int ret = 0;
        while (num > 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }

}
