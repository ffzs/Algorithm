package stoneGameVI;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2024/2/2 下午8:12
 */
public class Solution {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Integer[] ids = new Integer[n];

        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }

        Arrays.sort(ids, (i, j) -> aliceValues[j] + bobValues[j] - aliceValues[i] - bobValues[i]);

        int diff = 0;
        for (int i = 0; i < n; i++) {
            diff += i % 2 == 0 ? aliceValues[ids[i]] : -bobValues[ids[i]];
        }

        return Integer.compare(diff, 0);
    }

}
