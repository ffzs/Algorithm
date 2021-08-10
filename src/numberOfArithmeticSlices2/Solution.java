package numberOfArithmeticSlices2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/8/11 上午6:51
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] f= new Map[n];
        for (int i = 0; i < n; i++) f[i] = new HashMap<>();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                res += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return res;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int[][] dp= new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long k = (long)nums[i];
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(i);
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                List<Integer> lst = map.getOrDefault((2*(long)nums[j] - nums[i]), null);
                if (lst != null) {
                    for (int l : lst) {
                        if (l < j) dp[i][j] += dp[j][l] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

}
