package longestDiverseString;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/2/7 上午8:51
 */
public class Solution {

    public String longestDiverseString(int a, int b, int c) {
        int[][] cnt = {{0, a}, {1, b}, {2, c}};
        StringBuilder sb = new StringBuilder();

        boolean hasNext = true;
        while (hasNext) {
            Arrays.sort(cnt, (x1, x2) -> x2[1] - x1[1]);
            hasNext = false;
            for (int[] item : cnt) {
                if (item[1] <= 0) break;
                char it = (char)(item[0] + 'a');
                int len = sb.length();
                if (len >= 2 && sb.charAt(len - 1) == it && sb.charAt(len - 2) == it) continue;
                sb.append(it);
                item[1]--;
                hasNext = true;
                break;
            }
        }
        return sb.toString();
    }

}
