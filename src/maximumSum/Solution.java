package maximumSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/11/18 下午10:27
 */
public class Solution {

    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][2];

        for (int i = 0; i < n; i++) {
            f[i][0] = nums[i];
            f[i][1] = helper(nums[i]);
        }

        Arrays.sort(f, (a, b)-> a[1] - b[1]);

        int j, res = -1;
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            j = i + 1;
            lst.clear();
            lst.add(f[i][0]);
            while (j < n && f[i][1] == f[j][1]) {
                lst.add(f[j][0]);
                j += 1;
            }

            if (lst.size() >= 2) {
                lst.sort((a, b) -> b-a);
                res = Math.max(res, lst.get(0) + lst.get(1));
            }

            i = j -1;
        }
        return res;
    }

    private int helper (int num) {
        int ret = 0;
        while (num > 0) {
            ret += num%10;
            num /= 10;
        }
        return ret;
    }

}
