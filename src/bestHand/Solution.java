package bestHand;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/20 上午6:27
 */
public class Solution {

    public String bestHand(int[] ranks, char[] suits) {
        int cnt = 1;
        for (int i = 1; i < 5; i++) {
            if (suits[i] == suits[0]) cnt += 1;
        }
        if (cnt == 5) return "Flush";
        int[] num = new int[14];
        for (int rank : ranks) {
            num[rank] += 1;
        }
        boolean flag = false;
        for (int i : num) {
            if (i >= 3) return "Three of a Kind";
            if (i == 2) flag = true;
        }
        if (flag) return "Pair";
        return "High Card";
    }

}
