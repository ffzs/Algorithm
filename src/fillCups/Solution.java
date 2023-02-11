package fillCups;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/11 上午9:49
 */
public class Solution {

    public int fillCups(int[] amount) {
        int sum = 0, maxValue = 0;
        for (int i : amount) {
            sum += i;
            maxValue = Math.max(maxValue, i);
        }
        if (maxValue >= (sum - maxValue)) return maxValue;
        // 处理奇偶 + 1
        return (sum + 1) / 2;
    }

}
