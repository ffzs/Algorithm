package winnerOfGame;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/22 上午8:34
 */
public class Solution {

    public boolean winnerOfGame(String colors) {
        char[] cs = colors.toCharArray();
        int[] sum = new int[2];
        int i = 0, cnt, j;
        while (i < cs.length) {
            j = i + 1;
            cnt = 1;
            char pre = cs[i];
            while (j < cs.length && cs[j] == pre) {++j; ++cnt;}
            sum[pre - 'A'] += Math.max(0, cnt-2);
            i = j;
        }
        return (sum[0] - sum[1]) >= 1;
    }

}
