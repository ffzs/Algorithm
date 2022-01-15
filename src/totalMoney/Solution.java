package totalMoney;

/**
 * @author: ffzs
 * @Date: 2022/1/15 上午8:13
 */
public class Solution {
    private static int T = 28;
    public int totalMoney(int n) {
        int round = n / 7;
        int more = n % 7;
        int sum = (T + T + (round-1) * 7) * round / 2;
        for (int i = 1; i <= more; i++) {
            sum += i + round;
        }
        return sum;
    }

}
