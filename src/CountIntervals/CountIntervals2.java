package CountIntervals;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2023/12/16 上午11:20
 */
public class CountIntervals2 {

    TreeMap<Integer, Integer> tm;
    int cnt;
    public CountIntervals2() {
        tm = new TreeMap<>();
        cnt = 0;
    }

    public void add(int left, int right) {
        Map.Entry<Integer, Integer> it = tm.floorEntry(right);
        while (it != null && it.getValue() >= left) {
            int l = it.getKey(), r = it.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            cnt -= r - l + 1;
            tm.remove(l);
            it = tm.floorEntry(right);
        }

        tm.put(left, right);
        cnt += right - left + 1;
    }

    public int count() {
        return cnt;
    }

}
