package readBinaryWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/6/21 上午7:24
 */
public class Solution2 {
    List<String> res = new ArrayList<>();
    int[] hours = {1,2,4,8,0,0,0,0,0,0};
    int[] minutes = {0,0,0,0,1,2,4,8,16,32};

    public List<String> readBinaryWatch(int turnedOn) {
        dfs(turnedOn, 0, 0, 0);
        return res;
    }

    private void dfs (int num, int index, int hour, int minute) {
        if (hour >= 12 || minute >= 60) return;
        if (num == 0) {
            StringBuilder sb = new StringBuilder().append(hour).append(":").append(minute<10?"0":"").append(minute);
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < 10; i++) {
            dfs(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}
