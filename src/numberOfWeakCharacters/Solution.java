package numberOfWeakCharacters;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/1/28 上午6:20
 * [3,2], [2,1], [2,2]
 */
public class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int res = 0;
        Arrays.sort(properties, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        int max = 0;
        for (int[] property : properties) {
            if (property[1] < max) res++;
            else if (property[1] > max) max = property[1];
        }

        return res;
    }

}
