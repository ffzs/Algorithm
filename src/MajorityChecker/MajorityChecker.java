package MajorityChecker;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/4/16 上午8:55
 */
public class MajorityChecker {
    int[] arr;
    Map<Integer, List<Integer>> map;
    static final int k = 20;
    Random r = new Random();
    public MajorityChecker(int[] arr) {
        this.arr = arr;
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
    }

    public int query(int left, int right, int threshold) {
        int len = right - left + 1;
        for (int i = 0; i < k; i++) {
            int it = arr[left + r.nextInt(len)];
            List<Integer> lst = map.get(it);
            int cnt = findRight(lst, right) - findLeft(lst, left);
            if (cnt >= threshold) return it;
            else if (2 * cnt > len) return -1;
        }
        return -1;
    }

    private int findLeft (List<Integer> lst, int t) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (lst.get(mid) < t) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int findRight (List<Integer> lst, int t) {
        int l = 0, r = lst.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (lst.get(mid) <= t) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
