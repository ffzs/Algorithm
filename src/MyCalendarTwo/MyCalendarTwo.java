package MyCalendarTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2022/7/19 上午8:54
 */
public class MyCalendarTwo {
    TreeSet<int[]> set;
    public MyCalendarTwo() {
        set = new TreeSet<>((a, b) -> a[0]- b[0]);
    }

    public boolean book(int start, int end) {
        int[] e = set.ceiling(new int[]{start, 0, 0});
        List<int[]> lst = new ArrayList<>();

        while (e != null && e[1] < end) {
            if (e[2] == 2) return false;
            lst.add(e);
            e = set.ceiling(new int[]{e[0] + 1, 0, 0});
        }

        int r = 0, l;
        for (int[] ints : lst) {
            e = ints;
            r = e[0];
            l = e[1];
            int rr = Math.min(end - 1, r), lr = Math.max(start, l) - 1, ll = Math.min(start, l);
            set.remove(e);
            if (ll <= lr) set.add(new int[]{lr, ll, 1});
            set.add(new int[]{rr, lr + 1, 2});
            start = rr + 1;
        }

        int rr = Math.max(end - 1, r);
        if (start > rr) return true;
        set.add(new int[]{rr, start, 1});
        return true;
    }

}
