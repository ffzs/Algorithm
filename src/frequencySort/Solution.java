package frequencySort;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2021/7/3 上午7:28
 */
public class Solution {

    public String frequencySort(String s) {
        int[][] counter = new int[128][2];
        for (int i = 0; i < 128; i++) {
            counter[i][0] = i;
        }

        for (char c : s.toCharArray()) {
            counter[c- ' '][1]++;
        }

        Arrays.sort(counter, (a, b)-> b[1] - a[1]);

        StringBuilder sb = new StringBuilder();
        for (int[] ints : counter) {
            if (ints[1] == 0) break;
            char c = (char) (ints[0] + ' ');
            sb.append(String.valueOf(c).repeat(Math.max(0, ints[1])));
        }
        return sb.toString();
    }

}
