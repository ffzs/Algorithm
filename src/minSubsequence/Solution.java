package minSubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/8/4 上午9:14
 */
public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int[] cnt = new int[101];
        int sum = 0;
        for (int num : nums) {
            cnt[num] += 1;
            sum += num;
        }

        int t = 0;
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (cnt[i] == 0) continue;
            for (int j = 0; j < cnt[i]; j++) {
                t += i;
                res.add(i);
                if (t * 2 > sum) return res;
            }
        }
        return res;
    }

}
