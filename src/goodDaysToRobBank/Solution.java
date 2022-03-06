package goodDaysToRobBank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/3/6 上午8:00
 */
public class Solution {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        int[] pre = new int[n];
        int[] suf = new int[n];
        for (int i = 1; i < n - time; i++) {
            if (security[i-1] >= security[i]) pre[i] = pre[i-1]+1;
        }

        for (int i = n-2; i >= time; --i) {
            if (security[i+1] >= security[i]) suf[i] = suf[i+1]+1;
        }

        for (int i = time; i < n - time; i++) {
            if (pre[i] >= time && suf[i] >= time) res.add(i);
        }

        return res;
    }


}
