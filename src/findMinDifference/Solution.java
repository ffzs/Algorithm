package findMinDifference;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/1/18 上午7:43
 */
public class Solution {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size()>1440) {
            return 0;
        }
        int n = timePoints.size();
        int[] minutes = new int[n+1];
        for (int i = 0; i < n; i++) {
            minutes[i] = time2Minutes(timePoints.get(i));
        }
        Arrays.sort(minutes);
        minutes[0] = minutes[n] - 24 * 60;
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (minutes[i] - minutes[i-1] < res) res = minutes[i] - minutes[i-1];
        }
        return res;
    }

    private int time2Minutes (String t) {
        char[] cs = t.toCharArray();
        return ((cs[0]-'0') * 10 + cs[1] - '0') * 60 + (cs[3] - '0') * 10 + cs[4] - '0';
    }

}
