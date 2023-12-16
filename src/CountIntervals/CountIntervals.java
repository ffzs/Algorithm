package CountIntervals;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/12/16 上午8:44
 */
public class CountIntervals {
    List<int[]> tm;
    int cnt;
    public CountIntervals() {
        tm = new ArrayList<>();
        cnt = 0;
    }

    public void add(int left, int right) {
        if (tm.isEmpty()) {
            tm.add(new int[]{left, right});
            cnt += right - left + 1;
            return;
        }
        int l;
        int idx;
        if (tm.get(0)[0] > left) {
            l = left;
            if (right < tm.get(0)[0]) {
                tm.add(0, new int[]{l, right});
                cnt += right - l + 1;
                return;
            }
            idx = 0;
        }
        else {
            idx = biSearch(left);
            if (tm.get(idx)[1] >= left) {
                if (tm.get(idx)[1] >= right) return;
                int[] drop = tm.remove(idx);
                cnt -= drop[1] - drop[0] + 1;
                l = drop[0];
            }
            else {
                l = left;
                idx++;
            }
        }
        if (idx >= tm.size()|| right < tm.get(idx)[0]) {
            tm.add(idx, new int[]{l, right});
            cnt += right - l + 1;
            return;
        }

        while (idx < tm.size() && tm.get(idx)[1]<=right) {
            int[] drop = tm.remove(idx);
            cnt -= drop[1] - drop[0] + 1;
        }

        int r;
        if (idx >= tm.size() || right < tm.get(idx)[0]) r=right;
        else {
            int[] drop = tm.remove(idx);
            r = drop[1];
            cnt -= drop[1] - drop[0] + 1;
        }
        cnt += r - l + 1;
        tm.add(idx, new int[]{l, r});
    }

    private int search (int target) {
        if (tm.get(0)[0] >= target) return 0;
        int ret = 0;
        while (ret < tm.size() && tm.get(ret)[0] < target) ret++;
        return ret - 1;
    }

    private int biSearch (int target) {
        int l = 0, r = tm.size()-1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (tm.get(mid)[0] > target) r = mid - 1;
            else l = mid + 1;
        }
        return tm.get(l)[0] <= target ? l : l - 1;
    }

    public int count() {
        return cnt;
    }

}
