package checkPerfectNumber;

/**
 * @author: ffzs
 * @Date: 2021/12/31 上午7:55
 */
public class Solution {

    public boolean checkPerfectNumber(int num) {
        int res = 1;
        int r = (int)Math.sqrt(num);
        for (int i = 2; i <= r; i++) {
            if (num % i == 0) res += i + num/i;
        }

        if (r * r == num) res -= r;
        return res == num;
    }

}
