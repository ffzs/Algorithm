package numWaterBottles;

/**
 * @author: ffzs
 * @Date: 2021/12/17 上午7:32
 */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles, pre = 0, total = numBottles;
        while (total >= numExchange) {
            pre = total % numExchange;
            total /= numExchange;
            res += total;
            total += pre;
        }
        return res;
    }
}
