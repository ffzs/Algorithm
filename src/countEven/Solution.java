package countEven;

/**
 * @author: ffzs
 * @Date: 2023/1/6 上午8:42
 */
public class Solution {

    public int countEven(int num) {
        int ret = num / 10 * 5 - 1, remain = num % 10;
        int t = 0;
        while (num > 0) {
            t += num % 10;
            num /= 10;
        }

        if ((t & 1) == 0) return ret + remain / 2 + 1;
        else return  ret + (remain + 1) / 2;
    }

}
