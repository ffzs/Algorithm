package canCompleteCircuit;

/**
 * @author: ffzs
 * @Date: 2020/11/18 下午1:46
 */
public class Solution2 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sum = 0, cum = 0, res = 0;
        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            sum += remain;
            cum += remain;
            if (cum < 0) {
                res = i + 1;
                cum = 0;
            }
        }

        return sum >= 0 ? res : -1;
    }

}
