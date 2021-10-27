package reorderedPowerOf2;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/10/28 上午7:32
 */
public class Solution {
    static Set<Integer> set = new HashSet<>();
    static {
        for (int cur = 1; cur <= (int)1e9+10; cur *= 2) {
            set.add(cur);
        }
    }
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = getCount(n);
        for (int i : set) {
            if (compare(cnt, getCount(i))) return true;
        }
        return false;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 10; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static private int[] getCount(int n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[n % 10]++;
            n /= 10;
        }
        return cnt;
    }
}
