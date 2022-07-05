package MyCalendar;

import MyCalendarThree.MyCalendarThree;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2022/7/5 下午2:03
 */
public class MyCalendar {

    TreeSet<int[]> set;
    public MyCalendar() {
        set = new TreeSet<>((a, b) -> {
            if (a[1] <= b[0]) return -1;
            else if (a[0] >= b[1]) return 1;
            else return 0;
        });
    }

    public boolean book(int start, int end) {
        return set.add(new int[] {start, end});
    }

}
