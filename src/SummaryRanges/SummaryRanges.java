package SummaryRanges;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2021/10/9 上午6:42
 */
public class SummaryRanges {
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval1 = map.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> interval0 = map.floorEntry(val);

        if (interval0 != null && interval0.getKey() <= val && val<=interval0.getValue()) return;
        else {
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            if (leftAside && rightAside) {
                int left = interval0.getKey(), right = interval1.getValue();
                map.remove(interval0.getKey());
                map.remove(interval1.getKey());
                map.put(left, right);
            }
            else if (leftAside) map.put(interval0.getKey(), interval0.getValue() + 1);
            else if (rightAside) {
                int right = interval1.getValue();
                map.remove(interval1.getKey());
                map.put(val, right);
            }
            else map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int size = map.size();
        int[][] res = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            res[index++] = new int[]{left, right};
        }
        return res;
    }
}
