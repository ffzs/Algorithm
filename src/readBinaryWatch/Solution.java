package readBinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/6/21 上午7:09
 */
public class Solution {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        int n = 1<<11;
        for (int i = 0; i < n; i++) {
            int hour = i>>6, minute = i & 63;
            if (hour < 12 & minute < 60 & Integer.bitCount(i) == turnedOn) {
                res.add(hour + ":" + (minute < 10 ? "0":"") + minute);
            }
        }
        return res;
    }

}
