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

        Arrays.sort(f, (a, b)-> {
            if (a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        }
        );

        int j, res = -1;
        for (int i = 0; i < n; i++) {
            j = i + 1;
            while (j < n && f[i][1] == f[j][1]) {
                j += 1;
            }

            if (j - i >= 2) {
                res = Math.max(res, f[i][0] + f[i + 1][0]);
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
