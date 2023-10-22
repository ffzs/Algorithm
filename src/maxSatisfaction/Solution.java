package maxSatisfaction;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/10/22 上午8:42
 */
public class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int s = 0;
        int res = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            s += satisfaction[i];
            if (s<=0) break;
            res += s;
        }
        return res;
    }

}
