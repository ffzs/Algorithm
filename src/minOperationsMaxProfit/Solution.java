package minOperationsMaxProfit;

/**
 * @author: ffzs
 * @Date: 2024/1/1
 */
public class Solution {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost * 4 - runningCost < 0) return -1;
        int res = 0, rest = 0, cost = 0, times = 0, minTimes = 0;
        for (int customer : customers) {
            rest += customer;
            if (rest > 4) {
                rest -= 4;
                cost += boardingCost * 4 - runningCost;
            }
            else {
                cost += boardingCost * rest - runningCost;
                rest = 0;
            }
            times += 1;
            if (cost > res) {
                minTimes = times;
                res = cost;
            }
        }

        if (rest * boardingCost > runningCost) minTimes = times;
        minTimes += rest / 4;
        rest %= 4;

        return rest * boardingCost - runningCost > 0 ? minTimes + 1 : minTimes == 0 ? -1 : minTimes;
    }

}
