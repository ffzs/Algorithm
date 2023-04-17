package countDaysTogether;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/17 上午9:17
 */
public class Solution {
    final static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static {
        for (int i = 1; i <= 12; i++) {
            days[i] += days[i-1];
        }
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa = trans(arriveAlice), al = trans(leaveAlice);
        int ab = trans(arriveBob), lb = trans(leaveBob);
        if (aa > lb || ab > al) return 0;
        if (aa >= ab && aa <= lb) return Math.min(al, lb) - aa + 1;
        return Math.min(al, lb) - ab + 1;
    }

    private int trans(String s) {
        int month = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        int day = (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
        return days[month-1] + day;
    }

}
