package RangeModule;

import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2022/6/20 下午4:40
 */
public class RangeModule2 {
    TreeSet<int[]> ts;
    public RangeModule2() {
        ts = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public void addRange(int left, int right) {
        int[] cur = new int[]{left, right};
        int[] fl = ts.floor(cur);
        if (fl != null && fl[1] >= left) {
            fl[1] = Math.max(fl[1], right);
            cur = fl;
        }
        else ts.add(cur);

        while (true){
            int[] hi = ts.higher(cur);
            if (hi == null || hi[0] > cur[1]) break;
            else {
                cur[1] = Math.max(cur[1], hi[1]);
                ts.remove(hi);
            }
        }
    }

    public boolean queryRange(int left, int right) {
        int[] fl = ts.floor(new int[]{left, right});
        return fl != null && fl[1] >= right;
    }

    public void removeRange(int left, int right) {
        int[] cur = new int[]{left, right};
        int[] lo = ts.lower(cur);

        if (lo != null) {
            if (lo[1] > left) {
                if (lo[1] > right) ts.add(new int[] {right, lo[1]});
                lo[1] = left;
            }
        }

        while (true) {
           int[] ceil = ts.ceiling(cur);
           if (ceil == null || ceil[0] > right) break;
           else {
               if (ceil[1] <= right) ts.remove(ceil);
               else {
                   ceil[0] = right;
                   break;
               }
           }
        }
    }
}
